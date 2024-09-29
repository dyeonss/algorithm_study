import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
        int[] board=new int[101];
        boolean[] visited=new boolean[101];
        LinkedList<Integer> q=new LinkedList<>();
        int result=0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken()), y=Integer.parseInt(st.nextToken());
            board[x]=y;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u=Integer.parseInt(st.nextToken()), v=Integer.parseInt(st.nextToken());
            board[u]=v;
        }
        q.offer(1);
        visited[1]=true;

        while(!q.isEmpty()) {
            result++;
            for (int i = 0,size=q.size(); i <size; i++) {
                int p = q.poll();
                for (int j = 1; j <= 6; j++) {
                    int move = p + j;
                    if (move == 100) {
                        System.out.println(result);
                        return;
                    }
                    if (move <= 100 && !visited[move]) {
                        visited[move] = true;
                        if (board[move]!=0) move=board[move];
                        q.offer(move);
                    }
                }
            }
        }
    }
}
