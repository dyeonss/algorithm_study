import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        HashMap<String, Integer> t = new HashMap<>();
        int todayVal = Integer.valueOf(today.replace(".",""));
        ArrayList<Integer> result = new ArrayList<>();

        for(String term:terms)
            t.put(term.substring(0,1),Integer.valueOf(term.substring(2)));
        
        for(int i=0;i<privacies.length;i++){
            String[] p=privacies[i].substring(0,10).split("\\.");
            int year=Integer.valueOf(p[0]);
            int month=Integer.valueOf(p[1]);
            int day=Integer.valueOf(p[2]);
            int add=t.get(privacies[i].substring(11,12));
            if(month+add>12){
                if((month+add)%12==0)
                    year+=(month+add)/12-1;
                else
                    year+=(month+add)/12;
                month=(month+add)%12;
                if(month==0)    month=12;
            }
            else    month+=add;
            
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(year));
            if(month<10)    sb.append("0"+month);
            else sb.append(month);
            if(day<10)  sb.append("0"+day);
            else sb.append(day);
            System.out.println(sb.toString());
            if(Integer.valueOf(sb.toString())<=todayVal)    result.add(i+1);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}