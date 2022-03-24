package by.javacourse.task3.parser.impl;

import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComponentType;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.parser.BaseTextParser;

public class ParagraphParser implements BaseTextParser {
    public static final String SENTENCE_SPLIT = "(?<=([.!?]\s))";
    private BaseTextParser parser = new SentenceParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite paragraphComposite = new TextComposite(TextComponentType.PARAGRAPH);
        String[] sentences = text.split(SENTENCE_SPLIT);
        if (!text.isBlank()) {
            for (String sentence : sentences) {
                TextComponent sentenceComponent = parser.parse(sentence);
                paragraphComposite.add(sentenceComponent);
            }
        }

        return paragraphComposite;
    }
}
