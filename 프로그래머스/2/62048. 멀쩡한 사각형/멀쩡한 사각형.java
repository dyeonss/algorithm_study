import java.util.*;
class Solution {
    public long solution(int w, int h) {
        long answer = (long)w*(long)h-(w+h-gcd(w,h));
        return answer;
    }
    public static int gcd(int p, int q){
        if (q == 0) return p;
        return gcd(q, p%q);
     }
}