package by.javacourse.task3.interpreter;

import java.util.List;

public class Client {
    private Context context = new Context();

    public double handleMathExpression(List<MathExpression> expressions) {
        expressions.forEach(terminal -> terminal.interpret(context));
        return context.pop();
    }

}
