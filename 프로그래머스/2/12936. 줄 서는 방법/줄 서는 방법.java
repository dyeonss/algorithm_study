import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> nums=new ArrayList<>();
        long total=1;
        k--;
        
        for(int i=1;i<=n;i++){
            nums.add(i);
            total*=i;
        }
        
        for(int i=0;n>0;i++){
            total/=n;
            answer[i]=nums.get((int)(k/total));
            nums.remove((int)(k/total));
            k=k%total;
            n--;
        }
        return answer;
    }
}