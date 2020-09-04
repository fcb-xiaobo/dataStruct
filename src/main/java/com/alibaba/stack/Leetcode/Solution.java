package com.alibaba.stack.Leetcode;

import java.util.Stack;

/**
 * Created by 小波哥  2019/7/1 17:19
 * 使用stack匹配括号问题
 */
public class Solution {

    /**
     * 解题思路
     * 把( [ { push进入stack,与传入进来的字符串比较
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char lattle = s.charAt(i);
            /**
             * （[])
             */
            if (lattle == '(' || lattle == '[' || lattle == '{') {
                stack.push(lattle);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (lattle == '(' && pop != ')') {
                    return false;
                }
                if (lattle == '[' && pop != ']') {
                    return false;
                }
                if (lattle == '{' && pop != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean match = solution.isValid("([{])");
        System.out.println(match);
    }


}

