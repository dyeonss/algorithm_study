class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int a=0;a<=d;a+=k)
            answer+=(int)Math.sqrt((long)d*d-(long)a*a)/k+1;
        
        return answer;
    }
}