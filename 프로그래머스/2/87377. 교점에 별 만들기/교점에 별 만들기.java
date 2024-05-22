import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        HashSet<String> set=new HashSet<>();
        long xmax=Long.MIN_VALUE, xmin=Long.MAX_VALUE,
            ymax=Long.MIN_VALUE, ymin=Long.MAX_VALUE;
        
        for(int i=0;i<line.length-1;i++){
            for(int j=i+1;j<line.length;j++){
                long a=line[i][0], b=line[i][1], e=line[i][2],
                    c=line[j][0], d=line[j][1], f=line[j][2];
                double xm=a*d-b*c,xj=b*f-e*d, ym=xm, yj=e*c-a*f;
                if(xm!=0){
                    if((xj/xm)%1==0&&(yj/ym)%1==0){
                        // System.out.println((int)(xj/xm)+", "+(int)(yj/ym));
                        set.add((long)(xj/xm)+" "+(long)(yj/ym));
                        xmin=Math.min(xmin,(long)(xj/xm));
                        xmax=Math.max(xmax,(long)(xj/xm));
                        ymin=Math.min(ymin,(long)(yj/ym));
                        ymax=Math.max(ymax,(long)(yj/ym));
                    }
                }  
            }
        }
       
        StringBuilder sb=new StringBuilder();
        answer=new String[(int)(ymax-ymin)+1];
        for(int i=0;i<=xmax-xmin;i++)   sb.append(".");
        
        for(int i=0;i<=ymax-ymin;i++)   answer[i]=sb.toString();
        
        for(String s:set){
            String[] arr=s.split(" ");
            char[] ch=answer[(int)(ymax-Long.valueOf(arr[1]))].toCharArray();
            ch[(int)(Long.valueOf(arr[0])-xmin)]='*';
            answer[(int)(ymax-Long.valueOf(arr[1]))]=String.valueOf(ch);
        }
        return answer;
    }
}