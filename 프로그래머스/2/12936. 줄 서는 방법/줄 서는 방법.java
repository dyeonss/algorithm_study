import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list=new ArrayList<>();
        long total=1;
        for(int i=1;i<=n;i++)   list.add(i);
        for(int i=n;i>=1;i--)   total*=i;
        
        k--;
        int nn=n;
        for(int i=0;i<nn;i++){
            total=total/n;
            n--;
            answer[i]=list.get((int)(k/total));
            list.remove((int)(k/total));
            k=k%total;
        }
        return answer;
    }
}