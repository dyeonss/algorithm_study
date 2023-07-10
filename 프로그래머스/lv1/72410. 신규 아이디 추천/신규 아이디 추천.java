import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id=new_id.toLowerCase();
        new_id=new_id.replaceAll("[^0-9a-z\\.\\-\\_]","");
        new_id=new_id.replaceAll("\\.{2,}",".");
        if(new_id.charAt(0)=='.')   new_id=new_id.substring(1,new_id.length());
        if(new_id.length()>0&&new_id.charAt(new_id.length()-1)=='.')   new_id=new_id.substring(0,new_id.length()-1);
        if(new_id.length()==0)  new_id="a";
        else if(new_id.length()>15) new_id=new_id.substring(0,15);
        
        if(new_id.length()>0&&new_id.charAt(new_id.length()-1)=='.')   new_id=new_id.substring(0,new_id.length()-1);
        if(new_id.length()<=2){
            String str=new_id.substring(new_id.length()-1,new_id.length());
            for(int i=0;i<=3-new_id.length();i++)
                new_id+=str;
        }
        answer=new_id;
        return answer;
    }
}