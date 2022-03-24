package by.javacourse.task3.parser;

import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.exception.TextCustomException;
import by.javacourse.task3.parser.impl.TextParser;
import by.javacourse.task3.reader.TextReader;
import by.javacourse.task3.reader.impl.TextReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class TextParserTest {
    public static final String TEST_FILE = "src/test/resources/text_test_parser.txt";
    TextReader reader;
    BaseTextParser parser;
    TextComposite textComposite;
    String text;
    @BeforeClass
    public void setUp() {
        reader = new TextReaderImpl();
        parser = new TextParser();
        try {
            text = reader.readTextFromFile(TEST_FILE);
        } catch (TextCustomException e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void parseTest(){
        textComposite = parser.parse(text);
        String expected = "PARAGRAPH [SENTENCE [LEXEME [WORD [SYMBOL [I] SYMBOL [t] ] ] LEXEME [WORD [SYMBOL [w] SYMBOL [a] SYMBOL [s] ] ] LEXEME [WORD [SYMBOL [a] ] ] LEXEME [WORD [SYMBOL [t] SYMBOL [r] SYMBOL [i] SYMBOL [p] ] ] LEXEME [WORD [SYMBOL [a] SYMBOL [c] SYMBOL [r] SYMBOL [o] SYMBOL [s] SYMBOL [s] ] ] LEXEME [WORD [SYMBOL [t] SYMBOL [h] SYMBOL [e] ] ] LEXEME [WORD [SYMBOL [c] SYMBOL [o] SYMBOL [u] SYMBOL [n] SYMBOL [t] SYMBOL [r] SYMBOL [y] ] PUNCTUATION_MARK [.] ] ]SENTENCE [LEXEME [WORD [SYMBOL [M] SYMBOL [y] ] ] LEXEME [WORD [SYMBOL [t] SYMBOL [r] SYMBOL [i] SYMBOL [p] ] PUNCTUATION_MARK [!] ] ]]" +
                "\tPARAGRAPH [SENTENCE [LEXEME [WORD [SYMBOL [T] SYMBOL [i] SYMBOL [m] SYMBOL [e] ] ] LEXEME [WORD [SYMBOL [t] SYMBOL [o] ] ] LEXEME [WORD [SYMBOL [w] SYMBOL [o] SYMBOL [r] SYMBOL [k] ] PUNCTUATION_MARK [,] ] LEXEME [WORD [SYMBOL [a] ] PUNCTUATION_MARK [!] PUNCTUATION_MARK [=] WORD [SYMBOL [b] ] PUNCTUATION_MARK [,] ] LEXEME [WORD [SYMBOL [o] SYMBOL [b] ] PUNCTUATION_MARK [.] WORD [SYMBOL [t] SYMBOL [o] SYMBOL [S] SYMBOL [t] SYMBOL [r] SYMBOL [i] SYMBOL [n] SYMBOL [g] ] PUNCTUATION_MARK [?] ] ]]" +
                "\tPARAGRAPH [SENTENCE [LEXEME [WORD [SYMBOL [C] SYMBOL [a] SYMBOL [l] SYMBOL [c] SYMBOL [u] SYMBOL [l] SYMBOL [a] SYMBOL [t] SYMBOL [e] ] ] LEXEME [WORD [SYMBOL [-] NUMBER [1] NUMBER [6] SYMBOL [,] NUMBER [0] ] ] LEXEME [WORD [SYMBOL [p] SYMBOL [l] SYMBOL [e] SYMBOL [a] SYMBOL [s] SYMBOL [e] ] PUNCTUATION_MARK [.] ] ]]" +
                "\tPARAGRAPH [SENTENCE [LEXEME [WORD [SYMBOL [B] SYMBOL [y] SYMBOL [e] ] PUNCTUATION_MARK [.] ] ]]\t";
        String actual = textComposite.toString().replaceAll("\n", "").replaceAll("\r", "");
        Assert.assertEquals(actual, expected);
    }
}
