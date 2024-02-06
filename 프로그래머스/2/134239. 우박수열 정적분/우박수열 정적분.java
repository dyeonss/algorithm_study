import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Integer> list=new ArrayList<>();
        
        list.add(k);
        
        while(k!=1&&k>1){
            if(k%2==0)  k/=2;
            else k=k*3+1;
            list.add(k);
        }
        
        for(int i=0;i<ranges.length;i++){
            int a=ranges[i][0], b=list.size()-1-(-ranges[i][1]);
            if(a>b){
                answer[i]=-1.0;
                continue;
            }
            for(int j=a;j<b;j++){
                answer[i]+=(list.get(j)+list.get(j+1))*1/2.0;    
            }
        }
        return answer;
    }
}