package com.lorenzhoerb.leetcode.stack;

import javax.security.auth.callback.CallbackHandler;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(())[]"));
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(Character c : chars) {
           if(c == '(')  {
            stack.push(')');
           } else if (c == '{') {
               stack.push('}');
           } else if (c == '[') {
              stack.push(']') ;
           } else {
               if(stack.isEmpty() || stack.pop() != c) return false;
           }
        }
        return stack.isEmpty();
    }
}
