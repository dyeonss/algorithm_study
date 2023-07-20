import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
  
        while(!((Math.abs(a-b)==1)&&(a>b?(a%2==0&&b%2==1):(b%2==0&&a%2==1)))){
            if(a%2==1)  a=a/2+1;
            else if(a%2==0) a=a/2;
            
            if(b%2==1)  b=b/2+1;
            else if(b%2==0) b=b/2;
            
            answer++;
        }
        return answer;
    }
}