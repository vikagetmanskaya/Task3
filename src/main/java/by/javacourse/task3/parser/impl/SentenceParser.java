package by.javacourse.task3.parser.impl;

import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComponentType;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.parser.TextParser;

public class SentenceParser implements TextParser {
    private TextParser parser = new LexemeParser();
    public static final String LEXEME_SPLIT = "\s";
    @Override
    public TextComposite parse(String text) {
        TextComposite lexemeComposite = new TextComposite(TextComponentType.SENTENCE);
        String [] lexemes = text.split(LEXEME_SPLIT);
        if(!text.isBlank()) {
            for (String lexeme : lexemes) {
                TextComponent lexemeComponent = parser.parse(lexeme);
                lexemeComposite.add(lexemeComponent);
            }
        }
        return lexemeComposite;
    }
}
