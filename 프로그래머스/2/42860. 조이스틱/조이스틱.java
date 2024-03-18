class Solution {
    public int solution(String name) {
        int answer = name.length()-1;
        
        for(int i=0;i<name.length()-1;i++){
            int idx=i+1;
            if(name.charAt(idx)=='A'){
                while(idx<name.length()&&name.charAt(idx)=='A')  idx++;
                answer=Math.min(answer,i*2+name.length()-idx);
                answer=Math.min(answer,(name.length()-idx)*2+i);
            }
        }
        
        for(int i=0;i<name.length();i++)
            answer+=name.charAt(i)<='M'?name.charAt(i)-'A':'Z'-name.charAt(i)+1;
        
        return answer;
    }
}