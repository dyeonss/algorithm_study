import java.util.Scanner;

public class Main {
	static int [] list = new int[7];
	static int N=9;
	static int [] nj=new int[N];
	static boolean stop=false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < N; i++) {
			nj[i]=sc.nextInt();
		}
		ncr(0,0,0);
		
		for (int i = 0; i < 7; i++) {
			System.out.println(list[i]);
		}
	}

	private static void ncr(int start, int cnt, int total) {
		if(cnt==7) {
			if(total==100)
				stop=true;
			return;
		}
		for (int i = start; i < N; i++) {
			list[cnt]=nj[i];
			ncr(i+1,cnt+1,total+nj[i]);
			if(stop==true)	return;
		}
	}

}
