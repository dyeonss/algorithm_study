class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int R=12, L=10;
        for(int i=0;i<numbers.length;i++){
            int n=numbers[i];
            if(n==1||n==4||n==7){
                L=n;
                answer.append("L");
            }    
            else if(n==3||n==6||n==9){
                R=n;
                answer.append("R");
            }   
            else{
                if(n==0)    n=11;
                int lm = Math.abs(n-L)/3+Math.abs(n-L)%3;
                int rm = Math.abs(n-R)/3+Math.abs(n-R)%3;
                if(lm==rm){
                    if(hand.equals("right")){
                        R=n;
                        answer.append("R");
                    }  
                    else if(hand.equals("left")){
                        L=n;
                        answer.append("L");
                    }
                }
                else if(lm<rm){
                    L=n;
                    answer.append("L"); 
                }  
                else{
                    R=n;
                    answer.append("R");
                }    
            }
        }
        return answer.toString();
    }
}