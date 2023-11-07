import java.util.*;
class Solution {
    public class Song{
        int index;
        int time;
        String name;
        public Song(int index, int time, String name){
            this.index=index;
            this.time=time;
            this.name=name;
        }
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int[] times=new int[musicinfos.length];
        ArrayList<Song> arr=new ArrayList<>();
        
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
            String tmp="";
            
            info[3]=info[3].replace("C#","H");
            info[3]=info[3].replace("D#","I");
            info[3]=info[3].replace("F#","J");
            info[3]=info[3].replace("G#","K");
            info[3]=info[3].replace("A#","L");
            char[] ch=info[3].toCharArray();
            
            for(int j=0;j<times[i];j++)
                tmp+=String.valueOf(ch[j%ch.length]);
     
            if(tmp.indexOf(m)>=0)
                arr.add(new Song(i,times[i],info[2]));
        }
        
        arr.sort((a1,a2)->{if(a1.time==a2.time) return a1.index-a2.index;   return a2.time-a1.time;});

        if(arr.size()==0)   return answer;
        return arr.get(0).name;
    }
}