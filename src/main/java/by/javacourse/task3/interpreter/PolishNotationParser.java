package by.javacourse.task3.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.javacourse.task3.interpreter.MathOperation.*;

public class PolishNotationParser {
    private static final String POLISH_NOTATION_SPLIT = "\\p{Blank}+";

    public List<MathExpression> parse(String polishNotation) {
        List<MathExpression> expressions = new ArrayList<>();
        Arrays.asList(polishNotation.split(POLISH_NOTATION_SPLIT)).forEach(token -> {
            switch (token.charAt(0)) {
                case PLUS -> expressions.add(c -> c.push(c.pop() + c.pop()));

                case MINUS -> expressions.add(c -> c.push(-c.pop() + c.pop()));

                case MULTIPLY -> expressions.add(c -> c.push(c.pop() * c.pop()));

                case DIVIDE -> expressions.add(c -> c.push(1 / c.pop() * c.pop()));
                case UNARY_MINUS -> expressions.add(c -> c.push(-c.pop()));

                default -> expressions.add(c -> c.push(Double.parseDouble(token)));
            }
        });
        return expressions;
    }
}
