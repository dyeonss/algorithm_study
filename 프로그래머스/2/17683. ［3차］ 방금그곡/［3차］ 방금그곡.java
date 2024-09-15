import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m=replace(m);
        int max=0;
        
        for(int i=0;i<musicinfos.length;i++){
            String[] arr=musicinfos[i].split(",");
            int time=(Integer.valueOf(arr[1].substring(0,2))*60+Integer.valueOf(arr[1].substring(3)))-
                (Integer.valueOf(arr[0].substring(0,2))*60+Integer.valueOf(arr[0].substring(3)));
            char[] ch=replace(arr[3]).toCharArray();
            
            if(time>max){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<time+1;j++)   sb.append(String.valueOf(ch[j%ch.length]));
                if(sb.toString().contains(m)){
                    max=time;
                    answer=arr[2];
                }
            }
        }
        
        return answer==""?"(None)":answer;
    }
    public String replace(String s){
        s=s.replace("A#","H");
        s=s.replace("B#","I");
        s=s.replace("C#","J");
        s=s.replace("D#","K");
        s=s.replace("F#","L");
        s=s.replace("G#","M");
        return s;
    }
}