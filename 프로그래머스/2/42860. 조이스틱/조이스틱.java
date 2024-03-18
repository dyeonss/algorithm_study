class Solution {
    public int solution(String name) {
        int move=name.length();
        int answer=0;
        
        for(int i=0;i<name.length();i++){
            int idx=i+1;
            answer+=name.charAt(i)<='M'?name.charAt(i)-'A':'Z'-name.charAt(i)+1;
            while(idx<name.length()&&name.charAt(idx)=='A')  idx++;
                move=Math.min(move,i*2+name.length()-idx);
                move=Math.min(move,(name.length()-idx)*2+i);
        }
            
        answer+=move;
        return answer;
    }
}