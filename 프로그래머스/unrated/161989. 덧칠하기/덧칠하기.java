class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int min=section[0];
        int max=section[section.length-1];
        int cnt=1;
        
        for(int i=1;i<section.length;i++){
            if(section[i]-min+1<=m){
                cnt++;
            }
            else{
                min=section[i];
                cnt=1;
                answer++;
                }  
        }
        return answer;
    }
}