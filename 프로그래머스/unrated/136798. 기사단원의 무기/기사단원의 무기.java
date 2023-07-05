class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1;i<=number;i++){
            int cnt = divisor(i);
            if(cnt>limit)   answer+=power;
            else answer+=cnt;
        }
        return answer;
    }
    public int divisor(int n){
        int result=1;
        int i=2;
        
        while(i<=n/2){
            if(n%i==0)  result++;
            i++;
        }
        return n==1?result:result+1;
    }
}