import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String h1 = s1.split("[0-9]")[0].toLowerCase();
                String h2 = s2.split("[0-9]")[0].toLowerCase();
                String v1 = s1.substring(h1.length()).split("[^0-9]")[0];
                String v2 = s2.substring(h2.length()).split("[^0-9]")[0];
                if(v1.length()>5)    v1 = v1.substring(0,5);
                if(v2.length()>5)    v2 = v2.substring(0,5);
                int n1 = Integer.valueOf(v1);
                int n2 = Integer.valueOf(v2);
                if(h1.equals(h2))
                    return Integer.compare(n1,n2);
                else
                    return h1.compareTo(h2);
            }
        });
        
        for(int i=0;i<files.length;i++) answer[i]=files[i];
        
        return answer;
    }
}