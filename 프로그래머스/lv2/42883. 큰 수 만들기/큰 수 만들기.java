class Solution {
    public String solution(String number, int k) {
        int start=0, cnt=0;
        int x=number.length()-k;    //뽑아야하는 개수
        k=number.length()-k;
        StringBuilder sb=new StringBuilder("");
        
        while(cnt<x){
            int max = 0;
            for(int i=start;i<=number.length()-k;i++){
                int n=number.charAt(i)-'0';
                if(n>max){
                    max=n;
                    start=i+1;
                    
                }
            }
            k--;
            cnt++;
            sb.append(String.valueOf(max));
        }
        return sb.toString();
    }
}