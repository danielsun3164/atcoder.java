package abc.abc151_200.abc178;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード（貪欲法よる解法）
 */
public class ProblemF別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int j = 0;
			// 直前処理されたa[i]
			int prev = -1;
			for (int i = 0; i < n; i++) {
				if (prev != a[i]) {
					j = 0;
				}
				if (a[i] == b[i]) {
					for (; j < n; j++) {
						if ((a[j] != a[i]) && (b[j] != a[i])) {
							swap(b, i, j);
							break;
						}
					}
					if (a[i] == b[i]) {
						System.out.println("No");
						return;
					}
				}
				prev = a[i];
			}
			System.out.println("Yes");
			System.out.println(Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * 配列のi番目のものとj番目のものを交換する
	 * 
	 * @param array 配列
	 * @param i
	 * @param j
	 */
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
