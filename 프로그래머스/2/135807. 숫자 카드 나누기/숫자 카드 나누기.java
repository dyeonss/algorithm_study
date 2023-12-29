import java.util.*;
class Solution {
    public static ArrayList<Integer> result=new ArrayList<>();
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        ArrayList<Integer> cdA=getCd(arrayA);
        ArrayList<Integer> cdB=getCd(arrayB);

        Collections.sort(cdA);
        Collections.sort(cdB);
        getResults(cdA,arrayB);
        getResults(cdB,arrayA);
        
        if(result.size()==0)    return 0;
        Collections.sort(result,Collections.reverseOrder());
        return result.get(0);
    }
    public ArrayList<Integer> getCd(int[] array){
        ArrayList<Integer> min=new ArrayList<>();
        ArrayList<Integer> cd=new ArrayList<>();
        
        for(int i=1;i<=Math.sqrt(array[0]);i++){
            if(array[0]%i==0){
                min.add(i);
                min.add(array[0]/i);
            }
        }
        
        for(int i=0;i<min.size();i++){
            boolean check=true;
            for(int j=0;j<array.length;j++){
                if(array[j]%min.get(i)!=0){
                    check=false;
                    break;
                }
            }
            if(check)   cd.add(min.get(i));
        }
        return cd;
    }
    public void getResults(ArrayList<Integer> cd,int[] array){
        
        for(int i=cd.size()-1;i>=0;i--){
            boolean check=true;
            for(int j=0;j<array.length;j++){
                if(array[j]%cd.get(i)==0){
                    check=false;
                    break;
                }
            }
            if(check){
                result.add(cd.get(i));
                break;
            }
        }
    }
}