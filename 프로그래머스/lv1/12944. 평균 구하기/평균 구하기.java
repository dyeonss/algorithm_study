class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum=0;
        for(int n:arr){
            sum+=n;
        }
        answer = sum/(arr.length*1.0);
        return answer;
    }
}