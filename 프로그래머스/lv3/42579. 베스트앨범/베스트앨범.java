import java.util.*;

class Solution {
    class Song implements Comparable<Song>{
        int idx, pcnt;
        Song(int idx,int pcnt){
            this.idx=idx;
            this.pcnt=pcnt;
        }
        @Override 
        public int compareTo(Song o){
            if(this.pcnt==o.pcnt)
                return Integer.compare(this.idx,o.idx);
            return -Integer.compare(this.pcnt,o.pcnt);
        }
        @Override
        public String toString(){
            return this.idx+" "+this.pcnt;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        List <Integer> answer = new ArrayList<>();
        HashMap<String, Integer> gcnt = new HashMap<>();
        HashMap<String, PriorityQueue<Song>> songs = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            gcnt.put(genres[i],gcnt.getOrDefault(genres[i],0)+plays[i]);
            if(songs.get(genres[i])!=null){
                songs.get(genres[i]).offer(new Song(i,plays[i]));
            }
            else{
                PriorityQueue<Song> tmp = new PriorityQueue<>();
                tmp.offer(new Song(i,plays[i]));
                songs.put(genres[i],tmp);
            }
        }
        
        List<String> list = new ArrayList<>(gcnt.keySet());
        list.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return -Integer.compare(gcnt.get(o1),gcnt.get(o2));
            }
        });
        
        for(String s:list){
            int cnt=0;
            while(true){
                if(cnt==2)  break;
                if(songs.get(s).size()>0)
                    answer.add(songs.get(s).poll().idx);
                cnt++;
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}