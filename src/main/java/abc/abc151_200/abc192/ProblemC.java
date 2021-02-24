package abc.abc151_200.abc192;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] a = new long[k + 1];
			a[0] = n;
			IntStream.rangeClosed(1, k).forEach(i -> a[i] = f(a[i - 1]));
			System.out.println(a[k]);
		}
	}

	private static long f(long n) {
		char[] s = String.valueOf(n).toCharArray();
		Arrays.sort(s);
		char[] t = new char[s.length];
		IntStream.range(0, s.length).forEach(i -> t[i] = s[s.length - 1 - i]);
		return Long.parseLong(String.valueOf(t)) - Long.parseLong(String.valueOf(s));
	}
}
