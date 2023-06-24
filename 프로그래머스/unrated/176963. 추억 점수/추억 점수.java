import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        List<String> nmarr = Arrays.asList(name);
        
        for(int i=0;i<photo.length;i++){
            for(int j=0;j<photo[i].length;j++){
                int contain = nmarr.indexOf(photo[i][j]);
                if(contain!=-1)
                    answer[i]+=yearning[contain];
            }
        }
        return answer;
    }
}