package by.javacourse.task3.parser.impl;

import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComponentType;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.parser.TextParser;

public class ParagraphParser implements TextParser {
    private TextParser parser = new SentenceParser();
    public static final String SENTENCE_SPLIT = "(?<=([.!?.{3}]\s))";
    @Override
    public TextComposite parse(String text) {
        TextComposite paragraphComposite = new TextComposite(TextComponentType.PARAGRAPH);
        String[] sentences = text.split(SENTENCE_SPLIT);
        if(!text.isBlank()) {
            for (String sentence : sentences) {
                TextComponent sentenceComponent = parser.parse(sentence);
                paragraphComposite.add(sentenceComponent);
            }
        }

        return paragraphComposite;
    }
}
