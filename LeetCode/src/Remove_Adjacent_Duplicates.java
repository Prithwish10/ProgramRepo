//Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
//
//We repeatedly make duplicate removals on S until we no longer can.
//
//Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
//
// 
//
//Example 1:
//
//Input: "abbaca"
//Output: "ca"
//Explanation: 
//For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  
//The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

import java.util.Stack;

public class Remove_Adjacent_Duplicates {

public String removeDuplicates(String s) {
        
        if(s == null || s.length() == 0)
            return "";
        
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(stack.isEmpty())
                stack.add(ch);
            
            else{
                if(stack.peek() == ch)
                    stack.pop();
                else
                    stack.add(ch);
            }
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}
