class Solution {
    public int solution(int n) {
        int answer = 0;
        String str="";
        while(n>0){
            str += n%3;
            n = n/3;
        }
     
        int i=str.length()-1;
        int j=0;
        while(i>=0){
            if(str.charAt(i)!='0'){
                int tmp = Integer.valueOf(str.charAt(i))-'0';
                answer+=tmp*(Math.pow(3,j));
            }
            i--;
            j++;
        }
        
        return answer;
    }
}