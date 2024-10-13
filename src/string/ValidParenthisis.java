package string;

import java.util.Stack;

public class ValidParenthisis {
    public static void main(String[] args) {
        String str = "{[()]}";
        System.out.print(isValid(str));

    }
    private static boolean isValid(String str){
        Stack<Character> stack=new Stack<>();
        for(char ch:str.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char top=stack.peek();
                    if(top=='(' && ch==')' || top=='{' && ch=='}'
                    || top=='[' && ch==']'){
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
