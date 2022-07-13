import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        int cnum[] ={4,1,2};
        
        while(n>0){
            answer = answer + Integer.toString(cnum[n%3]);
            n = n%3==0? n/3-1:n/3;
        }
        
        answer = new StringBuffer(answer).reverse().toString();
        return answer;
    }
}