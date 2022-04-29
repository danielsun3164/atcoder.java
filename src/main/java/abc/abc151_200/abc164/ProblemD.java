package abc.abc151_200.abc164;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemD {

	/** 2019 */
	private static final int N = 2019;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			long answer = 0L;
			int[] remains = new int[N];
			Arrays.fill(remains, 0);
			remains[0] = 1;
			int now = 0, power = 1;
			for (int i = s.length - 1; i >= 0; i--) {
				now += (s[i] - '0') * power;
				now %= N;
				power = power * 10 % N;
				answer += remains[now];
				remains[now]++;
			}
			System.out.println(answer);
		}
	}
}
