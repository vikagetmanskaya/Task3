package by.javacourse.task3.parser.impl;

import by.javacourse.task3.entity.Symbol;
import by.javacourse.task3.entity.TextComponentType;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.parser.BaseTextParser;

public class WordParser implements BaseTextParser {

    private static final String SYMBOL_DELIMITER = "";
    private static final String NUMBER = "\\d";

    @Override
    public TextComposite parse(String text) {
        TextComposite wordComposite = new TextComposite(TextComponentType.WORD);
        String[] symbols = text.split(SYMBOL_DELIMITER);
        for (String symbol : symbols) {
            if (!symbol.isBlank()) {
                if (symbol.matches(NUMBER)) {
                    wordComposite.add(new Symbol(TextComponentType.NUMBER, symbol.charAt(0)));
                } else {
                    wordComposite.add(new Symbol(TextComponentType.SYMBOL, symbol.charAt(0)));
                }
            }
        }
        return wordComposite;
    }
}
