import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        TreeMap<String, String> map = new TreeMap<>();
        TreeMap<String, Integer> time = new TreeMap<>();
       
        for(String r: records){
            String [] arr = r.split(" ");
            if(map.get(arr[1])==null){   //입차 시
                map.put(arr[1], arr[0]);
            }
            else{   //출차 시
                int hour = Integer.valueOf(map.get(arr[1]).substring(0,2));
                int minute = Integer.valueOf(map.get(arr[1]).substring(3,5));
                int in = hour*60+minute;
                hour = Integer.valueOf(arr[0].substring(0,2));
                minute = Integer.valueOf(arr[0].substring(3,5));
                int out = hour*60+minute;
                map.remove(arr[1]);
                time.put(arr[1],time.getOrDefault(arr[1],0)+(out-in));
            }
        }
        
        if(map.size()>0){
            for(String m: map.keySet()){
                int hour = Integer.valueOf(map.get(m).substring(0,2));
                int minute = Integer.valueOf(map.get(m).substring(3,5));
                int in = hour*60+minute;
                int out = 23*60+59;
                time.put(m,time.getOrDefault(m, 0)+(out-in));
            }
        }
        
        answer = new int[time.size()];
        int i=0;
        for(String t: time.keySet()){
            int driveTime = time.get(t); //누적시간
   
            if(driveTime<=basicTime) answer[i]=basicFee;
            else{
                int tmp = (driveTime-basicTime)/unitTime;
                if((driveTime-basicTime)%unitTime!=0) tmp+=1;
                answer[i]=basicFee+tmp*unitFee;
            }
            i++;
        }
        return answer;
    }
}