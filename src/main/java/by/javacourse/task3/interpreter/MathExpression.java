package by.javacourse.task3.interpreter;

@FunctionalInterface
public interface MathExpression {
    void interpret(Context context);
}
