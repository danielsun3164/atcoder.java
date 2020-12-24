package abc.abc151_200.abc179;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int x = scanner.nextInt(), m = scanner.nextInt();
			List<Long> list = new ArrayList<>();
			// contains判定用
			Set<Long> set = new HashSet<>();
			long next = x % m;
			list.add(next);
			set.add(next);
			while (list.size() < n) {
				next = next * next % m;
				if (set.contains(next)) {
					break;
				}
				set.add(next);
				list.add(next);
			}
			if (list.size() == n) {
				// n項目に到達する場合
				System.out.println(list.stream().mapToLong(i -> i).sum());
			} else {
				// 繰り返しの始まるindex
				int start = list.indexOf(next);
				// 繰り返しの合計
				long loop = list.stream().skip(start).mapToLong(i -> i).sum();
				// 繰り返しが始まるまでの合計
				long startSum = list.stream().mapToLong(i -> i).limit(start).sum();
				// 繰り返しの回数
				long bai = (n - start) / (list.size() - start);
				// 繰り返し1周に満たない最後の部分の個数
				long remain = (n - start) % (list.size() - start);
				System.out.println(
						startSum + bai * loop + list.stream().mapToLong(i -> i).skip(start).limit(remain).sum());
			}
		}
	}
}
