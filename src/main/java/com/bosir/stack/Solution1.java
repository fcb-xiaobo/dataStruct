package com.bosir.stack;

import com.bosir.stack.array.MyArrayStack;

/**
 * @Auther: fanchengbo
 * @Date: 2022/10/14 13:57
 * @Description: 完整的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 */
public class Solution1 {
    public boolean isVaild(String s) {
        MyArrayStack<Character> stack = new MyArrayStack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character topChar = stack.pop();
                if(c=='}'&&topChar!='{'){
                    return false;
                }
                if(c==']'&&topChar!='['){
                    return false;
                }
                if(c==')'&&topChar!='('){
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {

        System.out.println((new Solution1()).isVaild("()[]{}"));
        System.out.println((new Solution1()).isVaild("([)]"));
    }

}