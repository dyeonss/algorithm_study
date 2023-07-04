class Solution {
    public int solution(String s) {
        int answer = 0;
        int x=1,nx=0;
        int idx=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(idx)==s.charAt(i))  x++;
            else    nx++;
            
            if(x==nx){
                idx=i+1;
                answer++;
                x=0;
                nx=0;
            }
        }
        if(x!=nx)   answer++;
        
        return answer;
    }
}