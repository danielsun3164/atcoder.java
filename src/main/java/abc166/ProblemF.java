package abc166;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] count = new int['Z'];
			count['A'] = scanner.nextInt();
			count['B'] = scanner.nextInt();
			count['C'] = scanner.nextInt();
			char[][] s = new char[n][];
			IntStream.range(0, n).forEach(i -> s[i] = scanner.next().toCharArray());
			List<String> answer = new ArrayList<>();
			boolean result = true;
			for (int i = 0; i < n; i++) {
				if (0 == count[s[i][0]] + count[s[i][1]]) {
					result = false;
					break;
				}
				if (count[s[i][0]] > count[s[i][1]]) {
					count[s[i][0]]--;
					count[s[i][1]]++;
					answer.add(String.valueOf(s[i][1]));
				} else if (count[s[i][0]] < count[s[i][1]]) {
					count[s[i][0]]++;
					count[s[i][1]]--;
					answer.add(String.valueOf(s[i][0]));
				} else {
					// count[s[i][0]] == count[s[i][1]]
					if (i < n - 1) {
						// 次のパターンで判定する
						if ((s[i][0] == s[i + 1][0]) && (s[i][1] == s[i + 1][1])) {
							// 次のパターンが同じとき
							count[s[i][0]]++;
							count[s[i][1]]--;
							answer.add(String.valueOf(s[i][0]));
						} else if ((s[i][0] == s[i + 1][0]) || (s[i][0] == s[i + 1][1])) {
							// 次のパターンと同じ文字のものを+1とする
							count[s[i][0]]++;
							count[s[i][1]]--;
							answer.add(String.valueOf(s[i][0]));
						} else {
							count[s[i][0]]--;
							count[s[i][1]]++;
							answer.add(String.valueOf(s[i][1]));
						}
					} else {
						count[s[i][0]]++;
						count[s[i][1]]--;
						answer.add(String.valueOf(s[i][0]));
					}
				}
			}
			System.out.println(result ? "Yes" : "No");
			if (result) {
				answer.forEach(System.out::println);
			}
		}
	}
}
