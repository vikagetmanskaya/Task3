package by.javacourse.task3.service;

import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.exception.TextCustomException;
import by.javacourse.task3.parser.BaseTextParser;
import by.javacourse.task3.parser.impl.TextParser;
import by.javacourse.task3.reader.TextReader;
import by.javacourse.task3.reader.impl.TextReaderImpl;
import by.javacourse.task3.service.impl.TextServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.fail;

public class TextServiceTest {
    private static final String pathToTestFile1 = "src/test/resources/text_test_service1.txt";
    private static final String pathToTestFile2 = "src/test/resources/text_test_service_2.txt";
    private TextService service;
    private TextComposite textComposite1;
    private TextComposite textComposite2;

    @BeforeClass
    public void setUp() {
        TextReader reader = new TextReaderImpl();
        BaseTextParser parser = new TextParser();
        service = new TextServiceImpl();
        try {
            String text1 = reader.readTextFromFile(pathToTestFile1);
            textComposite1 = parser.parse(text1);
            String text2 = reader.readTextFromFile(pathToTestFile2);
            textComposite2 = parser.parse(text2);
        } catch (TextCustomException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void sortParagraphsTest() {
        List<TextComponent> expected = List.of(textComposite1.getComponents().get(2), textComposite1.getComponents().get(0), textComposite1.getComponents().get(1));
        try {
            List<TextComponent> actual = service.sortParagraphs(textComposite1);
            Assert.assertEquals(actual, expected);
        } catch (TextCustomException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void findSentenceWithLongestWordTest() {
        List<TextComponent> expected = new ArrayList<>();
        expected.add((textComposite1.getComponents().get(0)).getComponents().get(2));
        try {
            List<TextComponent> actual = service.findSentenceWithLongestWord(textComposite1);
            Assert.assertEquals(actual, expected);
        } catch (TextCustomException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void deleteSentencesWithLessWordsTest() {
        int expected = 2;
        try {
            service.deleteSentencesWithLessWords(textComposite1, 7);
            int actual = textComposite1.getComponents().stream()
                    .mapToInt(paragraph -> paragraph.getComponents().size()).sum();
            Assert.assertEquals(actual, expected);
        } catch (TextCustomException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void findRepeatWords() {
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("SYMBOL [I] SYMBOL [T] ", 2);
        expected.put("SYMBOL [W] SYMBOL [A] SYMBOL [S] ", 1);
        expected.put("SYMBOL [A] ", 1);
        expected.put("SYMBOL [T] SYMBOL [R] SYMBOL [I] SYMBOL [P] ", 1);
        expected.put("SYMBOL [A] SYMBOL [C] SYMBOL [R] SYMBOL [O] SYMBOL [S] SYMBOL [S] ", 1);
        expected.put("SYMBOL [T] SYMBOL [H] SYMBOL [E] ", 1);
        expected.put("SYMBOL [C] SYMBOL [O] SYMBOL [U] SYMBOL [N] SYMBOL [T] SYMBOL [R] SYMBOL [Y] ", 2);
        expected.put("SYMBOL [I] SYMBOL [S] ", 1);
        expected.put("SYMBOL [B] SYMBOL [E] SYMBOL [A] SYMBOL [U] SYMBOL [T] SYMBOL [I] SYMBOL [F] SYMBOL [U] SYMBOL [L] ", 1);
        try {
            Map<String, Integer> actual = service.findRepeatWords(textComposite2);
            Assert.assertEquals(actual, expected);
        } catch (TextCustomException e) {
            fail(e.getMessage());
        }


    }

    @Test
    public void countVowelsAndConsonantsTest() {
        Map<Integer, Integer> expected = Collections.singletonMap(10, 16);
        TextComponent sentence = textComposite1.getComponents().get(1).getComponents().get(0);
        try {
            Map<Integer, Integer> actual = service.countVowelsAndConsonants(sentence);
            Assert.assertEquals(actual, expected);
        } catch (TextCustomException e) {
            fail(e.getMessage());
        }


    }
}
