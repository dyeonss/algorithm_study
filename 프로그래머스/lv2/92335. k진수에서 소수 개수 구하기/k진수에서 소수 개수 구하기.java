class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        String[] nums = s.split("0");
        
        for(String num: nums){
            if(num.equals(""))    continue;
            if(isPrimeNumber(Long.valueOf(num)))  answer++;
        }
        return answer;
    }
    public boolean isPrimeNumber(long n){
        long j=2;
        
        if(n==1)    return false;
        
        while(j<=Math.sqrt(n)){
            if(n%j==0)  return false;
            j++;
        }
        return true;
    }
}