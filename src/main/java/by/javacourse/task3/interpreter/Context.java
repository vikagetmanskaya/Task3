package by.javacourse.task3.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
    private Deque<Double> contextValue = new ArrayDeque<>();

    public Double pop() {
        return contextValue.pop();
    }

    public void push(Double number) {
        contextValue.push(number);
    }

}
