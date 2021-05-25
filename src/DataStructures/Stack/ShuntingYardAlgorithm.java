package DataStructures.Stack;

import java.util.Stack;

/**
 * the shunting-yard algorithm
 * is a method for parsing mathematical expressions specified in infix notation.
 * read more from Wikipedia  https://en.wikipedia.org/wiki/Shunting-yard_algorithm
 */
public class ShuntingYardAlgorithm {
    public static void main (String[] args) {
        assert toPostfix("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3").equals("342*15-23^^/+");
        assert toPostfix("( 1 - 5  ^ 2 ^ 3) " ).equals("1523^^-");
    }

    /**
     * simple function that converts infix to postfix using Shunting Yard Algorithm.
     * @param expression infix expression
     * @return postfix expression of the given infix.
     */
    public static String toPostfix(String expression){
        if (expression.isEmpty() || expression.isBlank())
            throw new IllegalArgumentException("expression cannot be empty.");
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (var c : expression.toCharArray()){
            if (Character.isLetterOrDigit(c))
                result.append(c);
            else if (isOperator(c)){
                while (!operatorStack.empty()  &&  (  getPrecedence( operatorStack.peek() ) > getPrecedence(c) )
                || ( !operatorStack.empty() && (getPrecedence(operatorStack.peek()) == getPrecedence(c) && !(c == '^') )
                        && operatorStack.peek() != '(') )
                {
                    result.append(operatorStack.pop());
                } // end of first while
                operatorStack.push(c);
            } // end of first else if
            else if (c == '('){
                operatorStack.push(c);
            } // end of second else if
            else if (c == ')'){
                while (!operatorStack.empty() && operatorStack.peek() != '('){
                    result.append(operatorStack.pop());
                } // end of second while
                /* If the stack runs out without finding a left parenthesis, then there are mismatched parentheses. */
                if (!operatorStack.empty())
                    operatorStack.pop();

                else
                    throw new RuntimeException("There are mismatched parentheses.");
            } // end of third else if
        }
        while (!operatorStack.empty()){
            /* If the operator token on the top of the stack is a parenthesis, then there are mismatched parentheses. */
            var operator = operatorStack.pop();
            if (operator == '(' || operator == ')')
                throw new RuntimeException("There are mismatched parentheses.");
            result.append(operator);
        }
        return result.toString();
    } // the running time is thus O(n)—linear in the size of the expression input.
    private static boolean isOperator(char c){
        return switch (c) {
            case '^', '*', '/', '%', '+', '-' -> true;
            default -> false;
        };
    }
    private static int getPrecedence(char operator){
        return switch (operator) {
            case '^' -> 4;
            case '*', '/', '%' -> 3;
            case '+', '-' -> 2;
            default -> 1;
        };
    }
}
