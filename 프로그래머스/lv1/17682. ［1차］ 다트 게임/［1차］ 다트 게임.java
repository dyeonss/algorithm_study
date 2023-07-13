import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String s="";
        boolean isNum=false;
        int[] score=new int[3];
        int j=0;
        ArrayList<Integer> star=new ArrayList<Integer>();
        ArrayList<Integer> sharp=new ArrayList<Integer>();
        
        for(int i=0;i<dartResult.length();i++){
            char c = dartResult.charAt(i);
            if(c>='0'&&c<='9'){
                s+=dartResult.substring(i,i+1);
            }
            else if(c=='S'||c=='D'||c=='T'){
                System.out.println(s);
                if(c=='S')  score[j]=Integer.valueOf(s);
                else if(c=='D') score[j]=(int)Math.pow(Integer.valueOf(s),2);
                else score[j]=(int)Math.pow(Integer.valueOf(s),3);
                s="";
                j++;
            }
            else if(c=='*'){
                if(j-1>=1){
                    score[j-2]=score[j-2]*2;
                    score[j-1]=score[j-1]*2;
                }
                else if(j-1==0)   score[j-1]=score[j-1]*2;
            }
            else if(c=='#'){
                score[j-1]=score[j-1]*-1;
                
            }
        }
        
        for(int sc:score)    answer+=sc;
        return answer;
    }
}