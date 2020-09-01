package abc.abc022;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int t = scanner.nextInt();
			// 入力データ
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			// 毎日の体重を計算
			int[] now = new int[n];
			now[0] = a[0];
			IntStream.range(1, n).forEach(i -> now[i] = a[i] + now[i - 1]);
			System.out.println(Arrays.stream(now).filter(i -> (i >= s) && (i <= t)).count());
		}
	}
}
