import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] Xarr=new int[10];
        int[] Yarr=new int[10];
        
        for(int i=0;i<X.length();i++)
            Xarr[X.charAt(i)-'0']++;
        
        for(int i=0;i<Y.length();i++){
            Yarr[Y.charAt(i)-'0']++;
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=9;i>=0;i--){
            if(Xarr[i]>0&&Yarr[i]>0){
                if(Xarr[i]<=Yarr[i]){
                    for(int j=0;j<Xarr[i];j++)  arr.add(i);
                }
                else{
                    for(int j=0;j<Yarr[i];j++)  arr.add(i);
                }
            }
        }
        
        if(arr.size()==0)   return "-1";
        else{
            for(int a:arr)
                answer.append(a);
           
            if(answer.toString().charAt(0)=='0')
                return "0";
        }
        
        return answer.toString();
    }
}