import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        boolean[] visited=new boolean[100001];
        LinkedList<int[]> q=new LinkedList<>();
        int result=0;
        visited[n]=true;
        q.offer(new int[]{n,0});

        while(!q.isEmpty()){
            int[] p=q.poll();

            if(p[0]==k){
                result=p[1];
                break;
            }
            if(0<=p[0]-1&&p[0]-1<=100000&&!visited[p[0]-1]){
                q.offer(new int[]{p[0]-1,p[1]+1});
                visited[p[0]-1]=true;
            }
            if(0<=p[0]+1&&p[0]+1<=100000&&!visited[p[0]+1]){
                q.offer(new int[]{p[0]+1,p[1]+1});
                visited[p[0]+1]=true;
            }
            if(0<=p[0]*2&&p[0]*2<=100000&&!visited[p[0]*2]){
                q.offer(new int[]{p[0]*2,p[1]+1});
                visited[p[0]*2]=true;
            }
        }
        System.out.println(result);
    }
}
