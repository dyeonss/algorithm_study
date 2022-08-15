import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int result;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        visited=new boolean[100001];
        bfs(N,K);
        System.out.println(result);
    }

    private static void bfs(int n, int k) {
        Queue<Integer> q=new LinkedList<>();

        q.offer(n);
        visited[n]=true;

        while (!q.isEmpty()){
            int len=q.size();

            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                if(cur==k)  return;

                if(cur-1>=0&&cur-1<=100000&&!visited[cur-1]){
                    q.offer(cur-1);
                    visited[cur-1]=true;
                }
                if(cur+1>=0&&cur+1<=100000&&!visited[cur+1]){
                    q.offer(cur+1);
                    visited[cur+1]=true;
                }
                if(cur*2>=0&&cur*2<=100000&&!visited[cur*2]){
                    q.offer(cur*2);
                    visited[cur*2]=true;
                }
            }
            result++;
        }
    }
}
