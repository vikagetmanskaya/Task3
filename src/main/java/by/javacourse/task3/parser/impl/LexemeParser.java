package by.javacourse.task3.parser.impl;

import by.javacourse.task3.entity.Symbol;
import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComponentType;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser implements TextParser {
    public static final Logger logger = LogManager.getLogger();
    private TextParser parser = new WordParser();
    public static final String WORD_CODE = "\\w+\\.\\w+\\(.*\\)";
    public static final String PUNCTUATION_MARK = "(\\p{Punct})";
    public static final String MARK_WORD_MARK = "(\\p{Punct}.+\\p{Punct})";
    public static final String MARK_WORD = "(\\p{Punct}.+)";
    public static final String CODE_MARK = "\\w+\\.\\w+\\(.*\\)\\p{Punct}";
    public static final String WORD_MARK = ".+\\p{Punct}";
    public static final String WORD_MARK_SPLIT = "(?=[\\(,.!?\\)])";

    @Override
    public TextComposite parse(String text) {
        TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);
        String word;
        Symbol symbol;
        if(text.isBlank()){
            logger.warn("Text is blank");
        }if(text.matches(WORD_CODE)){
            TextComponent wordComponent = parser.parse(text);
            lexemeComposite.add(wordComponent);
        }else if (text.matches(MARK_WORD_MARK)) {
            char firstSymbol = text.charAt(0);
            symbol = new Symbol(TextComponentType.PUNCTUATION_MARK, firstSymbol);
            lexemeComposite.add(symbol);
            word = text.substring(1, text.length() - 1);
            TextComponent wordComponent = parser.parse(word);
            lexemeComposite.add(wordComponent);
            char lastSymbol = text.charAt(text.length() - 1);
            symbol = new Symbol(TextComponentType.PUNCTUATION_MARK, lastSymbol);
            lexemeComposite.add(symbol);
        }else if (text.matches(MARK_WORD)) {
            char firstSymbol = text.charAt(0);
            symbol = new Symbol(TextComponentType.PUNCTUATION_MARK, firstSymbol);
            lexemeComposite.add(symbol);
            word = text.substring(1);
            TextComponent wordComponent = parser.parse(word);
            lexemeComposite.add(wordComponent);
        } else if (text.matches(CODE_MARK)) {
            word = text.substring(0, text.length() - 1);
            TextComponent wordComponent = parser.parse(word);
            lexemeComposite.add(wordComponent);
            char lastSymbol = text.charAt(text.length() - 1);
            symbol = new Symbol(TextComponentType.PUNCTUATION_MARK, lastSymbol);
            lexemeComposite.add(symbol);
        } else if (text.matches(WORD_MARK)) {
            String[] wordElements = text.split(WORD_MARK_SPLIT);
            for (String element : wordElements) {
                if (element.matches(PUNCTUATION_MARK)) {
                    char markSymbol = element.charAt(0);
                    symbol = new Symbol(TextComponentType.PUNCTUATION_MARK, markSymbol);
                    lexemeComposite.add(symbol);
                } else {
                    TextComponent wordComponent = parser.parse(element);
                    lexemeComposite.add(wordComponent);
                }
            }
        } else {
            TextComponent wordComponent = parser.parse(text);
            lexemeComposite.add(wordComponent);
        }
        return lexemeComposite;
    }
}
