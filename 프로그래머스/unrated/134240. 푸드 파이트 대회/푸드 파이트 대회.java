import java.util.*;
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
      
        for(int i=1;i<food.length;i++){
            if(food[i]==1)  continue;
            for(int j=0;j<food[i]/2;j++)
                sb.append(String.valueOf(i));
        }
        
        return sb.toString()+"0"+sb.reverse();
    }
}