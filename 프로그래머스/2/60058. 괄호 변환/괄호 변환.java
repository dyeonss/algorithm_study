import java.util.*;
class Solution {
    static StringBuilder answer=new StringBuilder();
    public String solution(String p) {
        if(right_bracket(p))    return p;
        start(p);
        return answer.toString();
    }
    public void start(String w){
        if(w.equals(""))
            return;
        
        String u="",v="";
        int l=0,r=0,idx=0;
        
        for(idx=0;idx<w.length();idx++){
            if(w.charAt(idx)=='(')    l++;
            else    r++;
            if(l==r)    break;
        }
        
        u=w.substring(0,++idx);
        v=w.substring(idx);
        
        if(right_bracket(u)){
            answer.append(u);
            start(v);
        }
        else{
            answer.append("(");
            start(v);
            answer.append(")");
            answer.append(reverse(u.substring(1,u.length()-1)));
        }
    }
    public boolean right_bracket(String u){
        Stack<String> stack=new Stack<String>();
        
        for(int i=0;i<u.length();i++){
            if(u.charAt(i)=='(')    stack.push("(");
            else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        if(stack.isEmpty())   return true;
        return false;
    }
    public String reverse(String u){
        StringBuilder str=new StringBuilder();
        
        for(int i=0;i<u.length();i++){
            if(u.charAt(i)=='(')    str.append(')');
            else    str.append('(');
        }
        return str.toString();
    }
}