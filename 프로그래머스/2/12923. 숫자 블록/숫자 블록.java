class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end-begin)+1];
        
        for(long i=begin;i<=end;i++){
            if(begin==1&&i-begin==0)  continue;
            for(int j=2;j<=(int)(Math.sqrt(i));j++){
                if(i%j==0){
                    if(i/j>10000000){
                        answer[(int)(i-begin)]=j;
                    }
                    else{
                        answer[(int)(i-begin)]=(int)(i/j);
                        break;    
                    }
                }  
            }    
            
            if(answer[(int)(i-begin)]==0)  answer[(int)(i-begin)]=1;
        }
        return answer;
    }
}