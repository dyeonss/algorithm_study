import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime=-1;
        int[] times=new int[musicinfos.length];
        
        m=m.replace("C#","H");
        m=m.replace("D#","I");
        m=m.replace("F#","J");
        m=m.replace("G#","K");
        m=m.replace("A#","L");
        
        for(int i=0;i<musicinfos.length;i++){
            String[] info=musicinfos[i].split(",");
            int start=Integer.valueOf(info[0].substring(0,2))*60+Integer.valueOf(info[0].substring(3));
            int end=Integer.valueOf(info[1].substring(0,2))*60+Integer.valueOf(info[1].substring(3));
            times[i]=end-start;
            StringBuilder tmp=new StringBuilder();
            
            info[3]=info[3].replace("C#","H");
            info[3]=info[3].replace("D#","I");
            info[3]=info[3].replace("F#","J");
            info[3]=info[3].replace("G#","K");
            info[3]=info[3].replace("A#","L");
            char[] ch=info[3].toCharArray();
            
            for(int j=0;j<times[i];j++)
                tmp.append(String.valueOf(ch[j%ch.length]));
     
            if(tmp.toString().contains(m)&&times[i]>maxTime){
                answer=info[2];
                maxTime=times[i];
            }
        }

        return answer;
    }
}