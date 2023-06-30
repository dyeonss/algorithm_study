class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int min=section[0];
        
        for(int i=1;i<section.length;i++){
            if(!(section[i]-min+1<=m)){
                min=section[i];
                answer++;
            }  
        }
        return answer;
    }
}