import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean ride = false;
        Arrays.sort(people);
        int i=0, j=people.length-1;
        
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
                j--;
            }
            else{
                j--;
            }
            answer++;
        }
        
        return answer;
    }
}