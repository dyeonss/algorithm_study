import java.util.*;
class Solution {
    public static class Pos{
        int r,c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int solution(String dirs) {
        int answer = 0;
        HashMap<String, ArrayList<Pos>> map = new HashMap<>();   //도착, 출발
        char[] arr = dirs.toCharArray();
        int r=0,c=0;
        for(char ch:arr){
            int nr = r;
            int nc = c;
            if(ch=='U')
                nr-=1;
            else if(ch=='D')
                nr+=1;
            else if(ch=='R')
                nc+=1;
            else
                nc-=1;
            
            if(nr<-5||nr>5||nc<-5||nc>5)    continue;
            
            if(map.containsKey(nr+" "+nc)){
                ArrayList<Pos> list = map.get(nr+" "+nc);
                boolean check = true;
                for(Pos p:list){
                    if(p.r==r&&p.c==c){
                        check = false;
                        break;
                    }
                }
                //처음 가는 길
                if(check){
                    list.add(new Pos(r,c));
                    map.put(nr+" "+nc,list);
                    list = new ArrayList<>();
                    if(map.get(r+" "+c)!=null){
                        list = map.get(r+" "+c);
                    }
                    list.add(new Pos(nr,nc));
                    map.put(r+" "+c,list);
                    answer++;
                }
            }
            else if(map.containsKey(r+" "+c)){
                ArrayList<Pos> list = map.get(r+" "+c);
                boolean check = true;
                for(Pos p:list){
                    if(p.r==nr&&p.c==nc){
                        check = false;
                        break;
                    }
                }
                //처음 가는 길
                if(check){
                    list.add(new Pos(nr,nc));
                    map.put(r+" "+c,list);
                    list = new ArrayList<>();
                    if(map.get(nr+" "+nc)!=null){
                        list = map.get(nr+" "+nc);
                    }
                    list.add(new Pos(r,c));
                    map.put(nr+" "+nc,list);
                    answer++;
                }
            }
            else{   
                ArrayList<Pos> list = new ArrayList<>();
                list.add(new Pos(r,c));
                map.put(nr+" "+nc,list);
                ArrayList<Pos> rev = new ArrayList<>();
                list.add(new Pos(nr,nc));
                map.put(r+" "+c,list);
                answer++;
            }
            r=nr;
            c=nc; 
        }
        return answer;
    }
}