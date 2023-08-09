import java.util.*;
import java.text.*;
class Solution {
    public int[] solution(int[] fees, String[] records) throws ParseException{
        int[] answer = {};
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        TreeMap<String, String> map = new TreeMap<>();
        TreeMap<String, Integer> time = new TreeMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        for(String r: records){
            String [] arr = r.split(" ");
            if(map.get(arr[1])==null){   //입차 시
                map.put(arr[1], arr[0]);
            }
            else{   //출차 시
                Date in = sdf.parse(map.get(arr[1])); //입차시간
                Date out = sdf.parse(arr[0]);  //출차시간
                int diff = (int)(out.getTime() - in.getTime())/(1000*60); 
                map.remove(arr[1]);
                time.put(arr[1],time.getOrDefault(arr[1],0)+diff);
            }
        }
        
        if(map.size()>0){
            for(String m: map.keySet()){
                Date in = sdf.parse(map.get(m)); //입차시간
                Date out = sdf.parse("23:59");  //출차시간
                int diff = (int)(out.getTime() - in.getTime())/(1000*60); 
                time.put(m,time.getOrDefault(m, 0)+diff);
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