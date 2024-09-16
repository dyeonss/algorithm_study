import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list=new ArrayList<>();
        long fact=1;
        int idx=0;
        
        for(int i=1;i<=n;i++){
            list.add(i);
            fact*=i;
        }
        
        while(fact!=1){
            answer[idx]=list.remove((int)((k-1)/(fact/n)%n));
            fact/=n;
            n--;
            idx++;
        }
        answer[idx]=list.remove(0);
        return answer;
    }
}