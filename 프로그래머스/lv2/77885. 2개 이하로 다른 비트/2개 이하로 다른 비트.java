class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            long n = numbers[i];
            if(n%2==0){
                answer[i]=n+1;
            }
            else{
                StringBuilder sb=new StringBuilder(Long.toBinaryString(n));
                int cnt=0;
                if(sb.toString().contains("01")){
                    for(int j=sb.length();j>=2;j--){
                        if(sb.substring(j-2,j).equals("01")){
                            sb.setCharAt(j-2,'1');
                            sb.setCharAt(j-1,'0');
                            break;
                        }
                    }
                }
                else{
                    sb=new StringBuilder(sb.substring(1));
                    sb=sb.insert(0,"10");
                }
                answer[i]=Long.parseLong(sb.toString(),2);
            }
        }
        return answer;
    }
}