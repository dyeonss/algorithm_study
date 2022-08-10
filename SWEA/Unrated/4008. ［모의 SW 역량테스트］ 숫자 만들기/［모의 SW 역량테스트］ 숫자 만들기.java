import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int result;
	static int[] op;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int j = 0;
			int cnt = 0;
			N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			int[] opsize = new int[4];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 4; i++) {
				opsize[i] = Integer.parseInt(st.nextToken());
				cnt += opsize[i];
			}

			op = new int[cnt];

			for (int i = 0; i < 4; i++) {
				while (opsize[i]-- > 0) {
					op[j] = i + 1;
					j++;
				}
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			do {
				result = num[0];
				for (int i = 0; i < op.length; i++) {
					int b = num[i + 1];
					calc(result, b, op[i]);
				}
				if (result < min)
					min = result;
				if (result > max)
					max = result;

			} while (np(op.length - 1));
			System.out.println("#" + test_case + " " + (max - min));
		}
	}

	private static boolean np(int size) {
		int i = size;

		while (i > 0 && op[i - 1] >= op[i])
			i--;

		if (i == 0)
			return false;

		int j = size;

		while (op[i - 1] >= op[j])
			j--;

		int temp = op[i - 1];

		op[i - 1] = op[j];
		op[j] = temp;

		int k = size;

		while (i < k) {
			temp = op[i];
			op[i] = op[k];
			op[k] = temp;
			i++;
			k--;
		}
		return true;
	}

	private static void calc(int a, int b, int op) {

		switch (op) {
		case 1:
			result = a + b;
			break;
		case 2:
			result = a - b;
			break;
		case 3:
			result = a * b;
			break;
		case 4:
			result = a / b;
			break;
		}
		return;
	}
}