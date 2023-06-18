import java.util.*;

class Solution {
    public long solution(long n) {
        List<Integer> arr = new ArrayList<>();
        
        while(n/10>0){
            arr.add((int)(n%10));
            n=n/10;
        }
        arr.add((int)(n%10));
       
        Collections.sort(arr, Collections.reverseOrder());
        String answer = "";
        for(int nn:arr){
            answer+=nn;
        }
        return Long.parseLong(answer);
    }
}