package abc.abc038;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int start = -1;
			int prev = Integer.MAX_VALUE;
			List<Integer> resultList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int now = scanner.nextInt();
				if (-1 == start) {
					// 最初の項目の場合
					start = i;
				} else {
					if (now <= prev) {
						// 数値が直前のもの以下場合
						resultList.add(i - start);
						start = i;
					}
				}
				prev = now;
			}
			// 最後の連続した数列の個数を追加
			resultList.add(n - start);
			System.out.println(resultList.stream().mapToLong(i -> ((long) i) * (i + 1) / 2L).sum());
		}
	}
}
