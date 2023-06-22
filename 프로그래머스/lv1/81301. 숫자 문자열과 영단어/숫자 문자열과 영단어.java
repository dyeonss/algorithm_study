import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String []number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0;i<number.length;i++){
            int index = s.indexOf(number[i]);
            if(index!=-1){
                s=s.replace(number[i],String.valueOf(i));
            }
        }
        return Integer.valueOf(s);
    }
}