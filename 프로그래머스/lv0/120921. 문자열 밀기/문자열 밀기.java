import java.util.*;
class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        int last = A.length()-1;
        
        if(A.equals(B)) return answer;
        
        for(int i=0;i<A.length();i++){
            A=A.substring(last)+A.substring(0,last);
            if(A.equals(B)){
                answer=i+1;
                break;
            }
        }
        return answer==0?-1:answer;
    }
}