import java.util.Scanner;

public class Main {
	static int total = 0;
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		while (N > 0) {
			if (N == 0)
				break;

			if (N % 5 == 0) {
				result++;
				N -= 5;
			} else if (N % 3 == 0) {
				result++;
				N -= 3;
			} else if (N > 5) {
				N -= 5;
				result++;
			} else if (N > 3) {
				N -= 3;
				result++;
			} else {
				result = -1;
				break;
			}
		}
		System.out.println(result);
	}
}
