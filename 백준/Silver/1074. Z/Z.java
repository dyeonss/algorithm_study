import java.util.Scanner;

public class Main {
	static int d=0;
	static int R,C;
	static int [] pos=new int[2];
	static boolean stop;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		R=sc.nextInt();
		C=sc.nextInt();
		
		find(0,0,(int)Math.pow(2, N));
		System.out.println(d);
	}
	private static void find(int r, int c, int n) {
		if(n==2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if(r+i==R&&c+j==C) {
						return;
					}
					d++;
				}
			}
		}
		else {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if((r+i*n/2<=R) && (R<r+i*n/2+(n/2)) && (c+j*n/2<=C) && (C<c+j*n/2+(n/2))) {
						find(r+i*n/2,c+j*n/2,n/2);
						return;
					}
					else {
						d+=(n/2)*(n/2);
					}
				}
			}
		}
	}
}
