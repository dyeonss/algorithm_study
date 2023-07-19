import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(stack.size()>0&&stack.peek().equals(s.substring(i,i+1))) stack.pop();
            else    stack.push(s.substring(i,i+1));
         
        }
        
        return stack.size()>0?0:1;
    }
}