class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            int len=s.length();
            s=s.replace("0","");
            answer[1]+=(len-s.length());
            answer[0]++;
            StringBuilder tmp = new StringBuilder();
            for(int i=s.length();i!=0;i=i/2){
                tmp.append(i%2);
            }
            s=tmp.reverse().toString();
        }
        
        return answer;
    }
}
