package by.javacourse.task3.interpreter;

import java.util.List;
import java.util.StringJoiner;

public class MathExpressionCalculator {
    private static final String STRING_JOINER_DELIMITER = "\s";
    private ExpressionParser expressionParser = new ExpressionParser();
    public Double calculate(String expression){
        List<String> expressions = expressionParser.parse(expression);
        StringJoiner exprString = new StringJoiner(STRING_JOINER_DELIMITER);

        for (String exp : expressions) {
            exprString.add(exp);
        }
        String polishNotationExpr = exprString.toString();
        PolishNotationParser polishNotationParser = new PolishNotationParser();
        List<MathExpression> mathExpressions = polishNotationParser.parse(polishNotationExpr);
        Client client = new Client();

        return client.handleMathExpression(mathExpressions);
    }
}
