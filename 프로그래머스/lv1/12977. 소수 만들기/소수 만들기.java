class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int n=nums[i]+nums[j]+nums[k];
                    int d=2;
                    boolean prime=true;
                    while(Math.pow(d,2)<=n){
                        if(n%d==0){
                            prime=false;
                            break;
                        }
                        d++;
                    }
                    if(prime)   answer++;
                }
            }
        }
        return answer;
    }
}