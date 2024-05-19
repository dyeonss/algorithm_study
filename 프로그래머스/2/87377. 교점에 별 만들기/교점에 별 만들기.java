import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        HashSet<String> set=new HashSet<>();
        int xmax=Integer.MIN_VALUE, xmin=Integer.MAX_VALUE,
            ymax=Integer.MIN_VALUE, ymin=Integer.MAX_VALUE;
        
        for(int i=0;i<line.length-1;i++){
            for(int j=i+1;j<line.length;j++){
                long a=line[i][0], b=line[i][1], e=line[i][2],
                    c=line[j][0], d=line[j][1], f=line[j][2];
                long xm=a*d-b*c,xj=b*f-e*d, ym=xm, yj=e*c-a*f;
                if(xm!=0){
                    if(xj%xm==0&&yj%ym==0){
                        set.add((int)(xj/xm)+" "+(int)(yj/ym));
                        xmin=Math.min(xmin,(int)(xj/xm));
                        xmax=Math.max(xmax,(int)(xj/xm));
                        ymin=Math.min(ymin,(int)(yj/ym));
                        ymax=Math.max(ymax,(int)(yj/ym));
                    }
                }  
            }
        }
       
        StringBuilder sb=new StringBuilder();
        answer=new String[ymax-ymin+1];
        for(int i=0;i<=xmax-xmin;i++)   sb.append(".");
        
        for(int i=0;i<=ymax-ymin;i++)   answer[i]=sb.toString();
        
        for(String s:set){
            String[] arr=s.split(" ");
            char[] ch=answer[ymax-Integer.valueOf(arr[1])].toCharArray();
            ch[Integer.valueOf(arr[0])-xmin]='*';
            answer[ymax-Integer.valueOf(arr[1])]=String.valueOf(ch);
        }
        return answer;
    }
}