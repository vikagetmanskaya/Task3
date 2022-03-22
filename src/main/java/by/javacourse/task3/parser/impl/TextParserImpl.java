package by.javacourse.task3.parser.impl;

import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComponentType;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.parser.TextParser;

public class TextParserImpl implements TextParser {
    private TextParser parser = new ParagraphParser();
    public static final String PARAGRAPH_SPLIT = "\t";
    @Override
    public TextComposite parse(String text) {
        TextComposite textComposite = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = text.strip().split(PARAGRAPH_SPLIT);
        if(!text.isBlank()) {
            for (String paragraph : paragraphs) {
                TextComponent paragraphComponent = parser.parse(paragraph);
                textComposite.add(paragraphComponent);
            }
        }
        return textComposite;
    }
}
