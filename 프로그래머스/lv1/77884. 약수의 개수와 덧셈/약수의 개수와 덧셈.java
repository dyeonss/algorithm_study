class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int n=left;n<=right;n++){
            int mod=1, cnt=0;
            while(mod<=n){
                if(n%mod==0)    cnt++;
                mod++;
            }
            if(cnt%2==0)    answer+=n;
            else    answer-=n;
        }
        return answer;
    }
}