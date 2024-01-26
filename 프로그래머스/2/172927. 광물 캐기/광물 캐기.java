import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer=0,sum=0;
        ArrayList<int[]> list=new ArrayList<>();
        
        HashMap<String,int[]> mineral=new HashMap<String,int[]>();
        
        mineral.put("diamond",new int[]{1,1,1});
        mineral.put("iron",new int[]{5,1,1});
        mineral.put("stone",new int[]{25,5,1});
        
        for(int i=0;i<picks.length;i++) sum+=picks[i];
        
        for(int i=0;i<minerals.length;i+=5){
            if(i/5>=sum)    break;
            int dcnt=0,icnt=0,scnt=0;
           
            for(int j=i;(j<i+5&&j<minerals.length);j++){
                int idx=0;
                switch(minerals[j]){
                    case "diamond": idx=0;break;
                    case "iron":    idx=1;break;
                    case "stone":   idx=2;break;
                }
                
                dcnt+=mineral.get("diamond")[idx];
                icnt+=mineral.get("iron")[idx];
                scnt+=mineral.get("stone")[idx];
            }
            list.add(new int[]{dcnt,icnt,scnt});
        }
        
        list.sort((o1,o2)->o2[2]-o1[2]);
        
        for(int[] arr:list){
            int idx=-1;
            if(picks[0]>0)
                idx=0;
            else if(picks[1]>0)
                idx=1;
            else if(picks[2]>0)
                idx=2;
            else    break;
            
            picks[idx]--;
            answer+=arr[idx];
        }
        return answer;
    }
}