package by.javacourse.task3.parser.impl;

import by.javacourse.task3.entity.Symbol;
import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComponentType;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.parser.TextParser;

public class WordParser implements TextParser {

    private static final String SYMBOL_DELIMITER = "";
    private final String LETTER_REGEX = "[a-zA-Z]";
    @Override
    public TextComposite parse(String text) {
       TextComposite wordComposite = new TextComposite(TextComponentType.WORD);
       String [] symbols = text.split(SYMBOL_DELIMITER);
       for(String symbol : symbols){
           if(!symbol.isBlank()) {
                   wordComposite.add(new Symbol(TextComponentType.LETTER, symbol.charAt(0)));
           }
       }
        return wordComposite;
    }
}
