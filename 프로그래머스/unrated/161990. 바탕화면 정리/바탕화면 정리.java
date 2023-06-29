import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        ArrayList<int[]> files = new ArrayList<>();
        
        for(int i=0;i<wallpaper.length;i++){
            if(wallpaper[i].contains("#")){
                for(int j=0;j<wallpaper[i].length();j++){
                    if(wallpaper[i].charAt(j)=='#')
                        files.add(new int[]{i,j});
                }
                
            }
        }
        int maxr=0, maxc=0, minr=50, minc=50;
        for(int[] a: files){
            maxr=Math.max(maxr,a[0]);
            maxc=Math.max(maxc,a[1]);
            minr=Math.min(minr,a[0]);
            minc=Math.min(minc,a[1]);
        }
        answer = new int[]{minr,minc,maxr+1,maxc+1};
        return answer;
    }
}