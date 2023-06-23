import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<food.length;i++){
            if(food[i]==1)  continue;
            for(int j=0;j<food[i]/2;j++){
                arr.add(i);
                sb.append(String.valueOf(i));
            }
        }
        
        sb.append("0");
        Collections.sort(arr,Collections.reverseOrder());
        for(Integer n: arr){
            sb.append(String.valueOf(n));
        }
        
        return sb.toString();
    }
}