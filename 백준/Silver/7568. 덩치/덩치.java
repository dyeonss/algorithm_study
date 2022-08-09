import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static class P {
        int weight;
        int height;

        public P(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
	static int N;
	static List<P> list = new ArrayList<>();
	static List<Integer> rank=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			
			list.add(new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < N; i++) {
			int cnt=1;
			for (int j = 0; j < N; j++) {
				if(list.get(i).height<list.get(j).height&&list.get(i).weight<list.get(j).weight) {
					cnt++;
				}
			}
			rank.add(cnt);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int s : rank) {
			sb.append(s).append(" ");
		}
		System.out.println(sb);
	}
}
