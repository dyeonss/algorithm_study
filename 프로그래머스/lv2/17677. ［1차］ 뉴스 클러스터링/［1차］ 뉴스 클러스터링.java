import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList<String> sArr1 = new ArrayList<>();
        ArrayList<String> sArr2 = new ArrayList<>();
        
        for(int i=0;i<str1.length()-1;i++){
            String s = str1.substring(i,i+2).toLowerCase();
            if(s.matches("^[a-zA-Z]*$"))    sArr1.add(s);
        }
        for(int i=0;i<str2.length()-1;i++){
            String s = str2.substring(i,i+2).toLowerCase();
            if(s.matches("^[a-zA-Z]*$"))    sArr2.add(s);
        }
 
        ArrayList<String> inter = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        
        for(String s : sArr1){
          if(sArr2.remove(s)){
            inter.add(s);
          }
          union.add(s);
      }
      
      for(String s : sArr2){
          union.add(s);
      }
        
        if(union.size()==0) return 65536;
        return (int)(inter.size()*1.0/union.size()*1.0*65536.0);
    }
}