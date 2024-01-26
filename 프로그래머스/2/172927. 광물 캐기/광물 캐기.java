import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer=0,sum=0;
        ArrayList<int[]> list=new ArrayList<>();
        HashMap<String,Integer> dia=new HashMap<String,Integer>();
        HashMap<String,Integer> iron=new HashMap<String,Integer>();
        HashMap<String,Integer> stn=new HashMap<String,Integer>();
        
        dia.put("diamond",1);
        dia.put("iron",1);
        dia.put("stone",1);
        iron.put("diamond",5);
        iron.put("iron",1);
        iron.put("stone",1);
        stn.put("diamond",25);
        stn.put("iron",5);
        stn.put("stone",1);
        
        for(int i=0;i<picks.length;i++) sum+=picks[i];
        
        for(int i=0;i<minerals.length;i+=5){
            if(i/5>=sum)    break;
            int dcnt=0,icnt=0,scnt=0;
           
            for(int j=i;(j<i+5&&j<minerals.length);j++){
                dcnt+=dia.get(minerals[j]);
                icnt+=iron.get(minerals[j]);
                scnt+=stn.get(minerals[j]);
            }
            list.add(new int[]{dcnt,icnt,scnt});
        }
        
        list.sort((o1,o2)->o2[2]-o1[2]);
        
        for(int[] arr:list){
            System.out.println(Arrays.toString(arr));
            if(picks[0]>0){
                picks[0]--;
                answer+=arr[0];
            }
            else if(picks[1]>0){
                picks[1]--;
                answer+=arr[1];
            }
            else if(picks[2]>0){
                picks[2]--;
                answer+=arr[2];
            }
        }
        return answer;
    }
}