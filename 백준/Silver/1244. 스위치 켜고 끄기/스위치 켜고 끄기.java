import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int sw [] = new int [101];
	static int N;
	static int student;
	static int gender;
	static int switchnum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		
		//스위치 수 입력 
		N=Integer.parseInt(br.readLine());
		
		//스위치 상태 
		StringTokenizer st=new StringTokenizer(br.readLine());
 		for (int i = 1; i <= N; i++) {
			sw[i]=Integer.parseInt(st.nextToken());
		}
 		//학생 수 
 		student=Integer.parseInt(br.readLine());
 		
 		
 		for (int i = 0; i < student; i++) {
 			st=new StringTokenizer(br.readLine());
 			gender=Integer.parseInt(st.nextToken());
 			switchnum=Integer.parseInt(st.nextToken());
 			//남학생 
			if(gender==1) {
				boy(switchnum,1);
			}
			//여학생 
			else {
				sw[switchnum]^=1;
				girl(switchnum,1);
				
			}
		}
 		
 		for(int i=1;i<=N;i++) {
 			sb.append(sw[i]).append(" ");
			if(i%20 == 0) sb.append("\n");
		}
 		
 		System.out.print(sb);
	}

	private static void girl(int idx, int d) {
		if (idx-d < 1 || idx+d > N) {
			return;
		}

		if (sw[idx-d] == sw[idx+d]) {
			sw[idx-d]^=1;
			sw[idx+d]^=1;
			d++;
		}
		else {
			return;
		}
		girl(idx,d);

	}
	private static void boy(int switchnum,int j) {
		if(j>N)
			return;
		else {
			if(j%switchnum==0){
				sw[j]^=1;
			}
			boy(switchnum,j+1);
		}
	}
}
