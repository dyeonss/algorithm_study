class Solution {
    static int max;
    static boolean [] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        dungeon(dungeons, k, 0);
        answer=max;
        return answer;
    }
    public void dungeon(int[][] dungeons, int k, int res){
        max = Math.max(res,max);
        
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i]){
                if(k>=dungeons[i][0]){
                    visited[i]=true;
                    dungeon(dungeons, k-dungeons[i][1],res+1);
                    visited[i]=false;
                }
            }
        }
    }
}