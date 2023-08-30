class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            long n = numbers[i];
            if(n%2==0){
                answer[i]=n+1;
            }
            else{
                String str=Long.toBinaryString(n);
                int cnt=0;
                int idx = str.lastIndexOf("01");
                if(idx!=-1)
                    str = str.substring(0,idx)+"10"+str.substring(idx+2);
                else
                    str = "10"+str.substring(1);
                
                answer[i]=Long.parseLong(str,2);
            }
        }
        return answer;
    }
}