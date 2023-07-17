import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<String> lStack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            String str = s.substring(i,i+1);
            if(str.equals("(")) lStack.push(str);
            else{
                if(lStack.size()>0) lStack.pop();
                else
                    return false;
            }
        }
        
        if(lStack.size()>0) answer = false;
        return answer;
    }
}