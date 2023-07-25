import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayList<String> arr = new ArrayList<>();
        
        for(char c: s.toCharArray()){
            arr.add(String.valueOf(c));
        }
        
        if(s.length()%2!=0) return answer;
        
        for(int i=0;i<s.length();i++){
            if(isCheck(arr)){
                answer++;
            }
            String tmp = arr.get(0);
            arr.remove(0);
            arr.add(tmp);
        }
        
        return answer;
    }
    public boolean isCheck(ArrayList<String> arr){
        boolean result = true;
        Stack<String>lstack = new Stack<>();
        
        for(String s:arr){
            if(s.equals("(")||s.equals("{")||s.equals("[")) lstack.push(s);
            else{
                if(lstack.size()>0){
                    if(lstack.peek().equals("(")&&s.equals(")"))    lstack.pop();
                    else if(lstack.peek().equals("{")&&s.equals("}"))    lstack.pop();
                    else if(lstack.peek().equals("[")&&s.equals("]"))    lstack.pop();
                }
            }
        }
        
        if(lstack.size()>0) result=false;
        return result;
        
    }
}