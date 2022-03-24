package by.javacourse.task3.parser.impl;

import by.javacourse.task3.entity.TextComponent;
import by.javacourse.task3.entity.TextComponentType;
import by.javacourse.task3.entity.TextComposite;
import by.javacourse.task3.interpreter.MathExpressionCalculator;
import by.javacourse.task3.parser.BaseTextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements BaseTextParser {
    public static final String LEXEME_SPLIT = "\\s+";
    private static final String ARITHMETIC_EXPRESSION_REGEX = "-?\\d(?:[+*\\-/]\\d)+";
    private MathExpressionCalculator calculator = new MathExpressionCalculator();
    private BaseTextParser parser = new LexemeParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = text.split(LEXEME_SPLIT);
        Pattern regex = Pattern.compile(ARITHMETIC_EXPRESSION_REGEX);
        if (!text.isBlank()) {
            for (String lexeme : lexemes) {
                Matcher matcher = regex.matcher(lexeme);
                if (matcher.find()) {
                    Double expressionResult = calculator.calculate(lexeme);
                    lexeme = String.format("%,.1f", expressionResult);
                }
                TextComponent lexemeComponent = parser.parse(lexeme);
                sentenceComposite.add(lexemeComponent);
            }
        }
        return sentenceComposite;
    }
}
