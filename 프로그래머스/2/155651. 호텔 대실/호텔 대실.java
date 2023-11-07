import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        ArrayList<String> arr = new ArrayList<>();
        
        Arrays.sort(book_time,(t1,t2)->{
            String[] str1=t1[0].split(":");
            String[] str2=t2[0].split(":");
            int start1=Integer.valueOf(str1[0]+str1[1]);
            int start2=Integer.valueOf(str2[0]+str2[1]);
            return start1-start2;
        });
        
        arr.add(book_time[0][1]);
        for(int i=1;i<book_time.length;i++){
            boolean check=false;
            for(int j=0;j<arr.size();j++){
                String[] endTime=arr.get(j).split(":");
                int end=Integer.valueOf(endTime[0])*60+Integer.valueOf(endTime[1])+10;
                String[] startTime=book_time[i][0].split(":");
                int start=Integer.valueOf(startTime[0])*60+Integer.valueOf(startTime[1]);
                
                if(start>=end){
                    arr.set(j,book_time[i][1]);
                    check=true;
                    break;
                }
            }
            if(!check){
                arr.add(book_time[i][1]);
            }  
        }
        
        return arr.size();
    }
}