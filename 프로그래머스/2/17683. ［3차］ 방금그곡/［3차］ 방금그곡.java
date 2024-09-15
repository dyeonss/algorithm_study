import java.util.*;
class Solution {
    class Music{
        int n,playTime;
        String name;
        public Music(int n,int playTime,String name){
            this.n=n;
            this.playTime=playTime;
            this.name=name;
        }
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        ArrayList<Music> list=new ArrayList<>();
        m=replace(m);
        
        for(int i=0;i<musicinfos.length;i++){
            String[] arr=musicinfos[i].split(",");
            int time=(Integer.valueOf(arr[1].substring(0,2))*60+Integer.valueOf(arr[1].substring(3)))-
                (Integer.valueOf(arr[0].substring(0,2))*60+Integer.valueOf(arr[0].substring(3)));
            char[] ch=replace(arr[3]).toCharArray();
            String s="";
            for(int j=0;j<time+1;j++)
                s+=String.valueOf(ch[j%ch.length]);
            if(s.contains(m))   list.add(new Music(i,time,arr[2]));
        }
        list.sort((o1,o2)->{if(o2.playTime==o1.playTime)    return o1.n-o2.n;
                            else    return o2.playTime-o1.playTime;});
        
        return list.size()>0?list.get(0).name:"(None)";
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