import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(!arr.contains(numbers[i]+numbers[j]))
                    arr.add(numbers[i]+numbers[j]);
            }
        }
        
        Collections.sort(arr);
        answer = arr.stream().mapToInt(i->i).toArray();
        return answer;
    }
}