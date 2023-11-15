import java.util.*;
import java.util.regex.*;
class Solution {
    static HashMap<Integer,String> calc=new HashMap<>();
    static long answer=0;
    public long solution(String expression) {
        String[][] prior={{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*","+"},{"*","-","+"},{"*","+","-"}}; 
        
        expression=expression.replace("+","/+");
        expression=expression.replace("-","/-");
        expression=expression.replace("*","/*");
        for(int i=0;i<6;i++){
            String str=expression;
            for(int j=0;j<3;j++){
                String c=prior[i][j];
                
                while(true){
                    Pattern p=Pattern.compile("m*[0-9]+/\\"+c+"m*[0-9]+");
                    Matcher m=p.matcher(str);
                    if(!m.find())   break;
                    String s=m.group();
                    String[] arr=s.split("/\\"+c);
                    Long result=0L,n1=0L,n2=0L;
                    System.out.println("s: "+s);

                    arr[0]=arr[0].replace("m","-");
                    arr[1]=arr[1].replace("m","-");
                    System.out.println("arr: "+arr[0]+" "+arr[1]);
                    n1=Long.valueOf(arr[0]);
                    n2=Long.valueOf(arr[1]);

                    if(c.equals("+")){
                        result=n1+n2;
                    }
                    else if(c.equals("-")){
                        result=n1-n2;
                    }
                    else{
                        result=n1*n2;
                    }
                    str=str.replace(s,result<0?"m"+String.valueOf(Math.abs(result)):String.valueOf(result));
                    }
                }
            str=str.replace("m","-");
            answer=Math.max(Math.abs(Long.valueOf(str)),answer);
        }
        return answer;
    }
    
}
