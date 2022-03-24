package by.javacourse.task3.interpreter;

import java.util.*;

public class ExpressionParser {
    private static final String DELIMITER_ARRAY_OPERATORS = "";
    private static final String MATH_OPERATORS = "u+-*/";
    private static final String DELIMITERS = "()" + MATH_OPERATORS;
    public static boolean flag = true;

    private static boolean isDelimiter(String token) {
        if (token.length() != 1) {
            return false;
        }
        for (int i = 0; i < DELIMITERS.length(); i++) {
            if (token.charAt(0) == DELIMITERS.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOperator(String token) {
        for (int i = 0; i < MATH_OPERATORS.length(); i++) {
            if (token.charAt(0) == MATH_OPERATORS.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private static int priority(String token) {
        if (token.equals("(")) {
            return 1;
        }
        if (token.equals("+") || token.equals("-")) {
            return 2;
        }
        if (token.equals("*") || token.equals("/")) {
            return 3;
        }
        return 4;
    }

    public List<String> parse(String infix) {
        List<String> postfix = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        StringTokenizer tokenizer = new StringTokenizer(infix, DELIMITERS, true);
        String prev = "";
        String curr;

        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();

            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                flag = false;
                return postfix;
            } else if (isDelimiter(curr)) {
                if (curr.equals("(")) {
                    stack.push(curr);
                } else if (curr.equals(")")) {
                    while (true) {
                        assert stack.peek() != null;
                        if (stack.peek().equals("(")) break;
                        postfix.add(stack.pop());
                        if (stack.isEmpty()) {
                            flag = false;
                            return postfix;
                        }
                    }
                    stack.pop();
                } else {
                    if (curr.equals("-") && (prev.equals("") || isDelimiter(prev) && !prev.equals(")"))) {
                        String[] array = MATH_OPERATORS.split(DELIMITER_ARRAY_OPERATORS);
                        curr = array[0];
                    } else {
                        while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))) {
                            postfix.add(stack.pop());
                        }
                    }
                    stack.push(curr);
                }
            } else {
                postfix.add(curr);
            }
            prev = curr;
        }
        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) {
                postfix.add(stack.pop());
            } else {
                flag = false;
                return postfix;
            }
        }
        return postfix;
    }
}
