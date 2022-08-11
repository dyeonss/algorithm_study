import java.util.Scanner;

public class Main {
	static int [] nums;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		nums=new int[N];
		npir(0);
	}

	private static void npir(int cnt) {
		if(cnt==N) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < cnt; j++) {
				sb.append(nums[j]);
			}
			System.out.println(sb.toString());
			return ;
		}
		
		for (int i = 0; i <= 9; i++) {
			nums[cnt]=i+1;
			
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < cnt+1; j++) {
				sb.append(nums[j]);
			}
			if(!isP(Integer.parseInt(sb.toString()))) {
				continue;
			}
			npir(cnt+1);
		}
	}
	
	private static boolean isP(int n) {
		//1보다 큰 자연수 중 1과 자기자신만 약수로 가지는 수가 소수이기 때문에 1은 소수아니다. 
		if(n==1)
			return false;
		//2~제곱근(int형으로 변환)까지 나눠서 떨어지지 않으면 소수이다.
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
