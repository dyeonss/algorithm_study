import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N,M,res;
    static boolean connect;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N=Integer.parseInt(br.readLine());
            M=Integer.parseInt(br.readLine());
            List<Integer> [] big=new ArrayList[N];
            List<Integer> [] small=new ArrayList[N];
            res=0;

            for (int i = 0; i < N; i++) {
                big[i]=new ArrayList<>();
                small[i]=new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken())-1;
                int b= Integer.parseInt(st.nextToken())-1;
                big[s].add(b);
                small[b].add(s);
            }
            for (int i = 0; i < N; i++) {
                connect=true;
                boolean [] visited=new boolean[N];
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i]=true;
                while(!q.isEmpty()){
                    int now = q.poll();

                    for (int j = 0; j < big[now].size(); j++) {
                        if(!visited[big[now].get(j)]){
                            q.offer(big[now].get(j));
                            visited[big[now].get(j)]=true;
                        }
                    }
                }
                q.offer(i);
                while(!q.isEmpty()){
                    int now = q.poll();
                    for (int j = 0; j < small[now].size(); j++) {
                        if(!visited[small[now].get(j)]){
                            q.offer(small[now].get(j));
                            visited[small[now].get(j)]=true;
                        }
                    }
                }
                for (int j = 0; j < N; j++) {
                    if(visited[j]==false){
                        connect=false;
                        break;
                    }
                }
                res=(!connect?res:res+1);
            }
            System.out.println("#"+tc+" "+res);
        }
    }
}