import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int [id_list.length];
        HashMap<String, ArrayList<String>> map = new HashMap();
        HashMap<String, Integer> complain = new HashMap();
        
        for(String id: id_list){
            map.put(id, new ArrayList<String>());
            complain.put(id, 0);
        }
        
        report = Arrays.stream(report).distinct().toArray(String[]::new);
        
        for(int i=0;i<report.length;i++){
            String [] sarr = report[i].split(" ");
            if(!map.get(sarr[0]).contains(sarr[1])){
                map.get(sarr[0]).add(sarr[1]);
                complain.put(sarr[1], complain.get(sarr[1])+1);
            }
        }
        
        for(String id: id_list){
            if(complain.get(id)>=k){
                for(int j=0;j<id_list.length;j++){
                    if(map.get(id_list[j]).indexOf(id)!=-1){
                        answer[j]++;
                    }
                }
            }
        }
        return answer;
    }
}