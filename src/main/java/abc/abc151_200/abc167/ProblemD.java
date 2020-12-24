package abc.abc151_200.abc167;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			int[] a = new int[n + 1];
			IntStream.rangeClosed(1, n).forEach(i -> a[i] = scanner.nextInt());
			List<Integer> list = new ArrayList<>();
			// containsを計算用（実行時間オーバー対応）
			Set<Integer> set = new HashSet<>();
			list.add(1);
			set.add(1);
			int index = 1, count = 0;
			while (!set.contains(a[index])) {
				list.add(a[index]);
				set.add(a[index]);
				count++;
				if (k == count) {
					System.out.println(a[index]);
					return;
				}
				index = a[index];
			}
			int start = list.indexOf(a[index]);
			System.out.println(list.get(start + (int) ((k - list.size()) % (list.size() - start))));
		}
	}
}
