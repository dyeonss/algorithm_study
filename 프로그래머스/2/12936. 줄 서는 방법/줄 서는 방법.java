import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list=new ArrayList<>();
        long cnt=1;
        int idx=0;
        
        for(int i=1;i<=n;i++){
            list.add(i);
            cnt*=i;
        }    
        k--;
        
        while(n>0){
            answer[idx++]=list.remove((int)(k/(cnt/n)));
            k%=(cnt/n);
            cnt/=n;
            n--;
        }
        
        return answer;
    }
}