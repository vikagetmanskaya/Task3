package by.javacourse.task3.parser.impl;

import by.javacourse.task3.entity.Symbol;
import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComponentType;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.parser.BaseTextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements BaseTextParser {
    private static final String WORD_REGEX = "^[A-Za-z]+|-?\\d+,\\d+|-?\\d+$";
    private static final String WORD_PUNCTUATION = "[A-Za-z]+|-?\\d+(?:,\\d+)?|[\\p{Punct}]";
    private BaseTextParser parser = new WordParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);
        Pattern regex = Pattern.compile(WORD_PUNCTUATION);
        Matcher matcher = regex.matcher(text);
        Pattern wordPattern = Pattern.compile(WORD_REGEX);
        while (matcher.find()) {
            String word = matcher.group();
            Matcher wordMatcher = wordPattern.matcher(word);
            if (wordMatcher.find()) {
                TextComposite wordComponent = parser.parse(word);
                lexemeComposite.add(wordComponent);
            } else {
                TextComponent mark = new Symbol(TextComponentType.PUNCTUATION_MARK, word.charAt(0));
                lexemeComposite.add(mark);
            }
        }
        return lexemeComposite;
    }

}
