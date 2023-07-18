import java.util.*;
class Solution {
    public int solution(int n) {
        String s = Integer.toBinaryString(n);
        s = s.replace("0","");
        
        while(true){
            String tmp = Integer.toBinaryString(++n);
            tmp = tmp.replace("0","");
            if(s.length()==tmp.length())    break;
        }
        
        return n;
    }
}