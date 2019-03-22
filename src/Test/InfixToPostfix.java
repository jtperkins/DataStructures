package Test;

import Stack.Stack;

import java.util.Scanner;

public class InfixToPostfix {

    private final static char ADD = '+';
    private final static char SUBTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';

    private static Stack<Character> stack;

    static int precedence(char ch)
    {
        switch (ch)
        {
            case ADD:
            case SUBTRACT:
                return 1;

            case MULTIPLY:
            case DIVIDE:
                return 2;
        }
        return -1;
    }

    static String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<Character>();

        String token;
        Scanner parser = new Scanner(exp);

        while (parser.hasNext()) {
            token = parser.next();

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(token.charAt(0)))
                result += " " + token;

            // If the scanned character is an '(', push it to the stack.
            else if (token.charAt(0) == '(')
                stack.push(token.charAt(0));

            //  If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered.
            else if (token.charAt(0) == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += " " + stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && precedence(token.charAt(0)) <= precedence(stack.peek()))
                    result += " " + stack.pop();
                stack.push(token.charAt(0));
            }
        }


        // pop all the operators from the stack
        while (!stack.isEmpty())
            result += " " + stack.pop();

        return result.trim();
    }

    public static void main(String[] args)
    {
        String exp = "( 3 * 4 - ( 2 + 5 ) ) * 4 / 2";
        System.out.println(infixToPostfix(exp));
    }

}

