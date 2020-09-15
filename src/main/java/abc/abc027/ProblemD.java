package abc.abc027;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			// '-'と'+'の個数
			int minus = 0, plus = 0;
			// (自分より右の'+'の個数)-(自分より右の'-'の個数)の一覧
			List<Integer> list = new ArrayList<>();
			for (int i = s.length - 1; i >= 0; i--) {
				switch (s[i]) {
				case '+':
					plus++;
					break;
				case '-':
					minus++;
					break;
				case 'M':
				default:
					list.add(plus - minus);
				}
			}
			list.sort((x, y) -> x.compareTo(y));
			System.out.println(IntStream.range(list.size() / 2, list.size()).map(i -> list.get(i)).sum()
					- IntStream.range(0, list.size() / 2).map(i -> list.get(i)).sum());
		}
	}
}
