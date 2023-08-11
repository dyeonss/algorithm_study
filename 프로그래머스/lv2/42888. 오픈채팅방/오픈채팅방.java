import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String,String> map = new HashMap<>();
        int cnt = 0;
        for(String r:record){
            String[] arr = r.split(" ");
            if(arr[0].equals("Change")){
                map.put(arr[1],arr[2]);
            }
            else if(arr[0].equals("Enter")){
                cnt++;
                map.put(arr[1],arr[2]);
            }
            else
                cnt++;
        }
        
        answer = new String[cnt];
        int i = 0;
       
        for(String r:record){
            String[] arr = r.split(" ");
            if(arr[0].equals("Enter")){
                answer[i++]=map.get(arr[1])+"님이 들어왔습니다.";
            }
            else if(arr[0].equals("Leave")){
                answer[i++]=map.get(arr[1])+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}