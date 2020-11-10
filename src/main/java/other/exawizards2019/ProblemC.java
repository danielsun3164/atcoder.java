package other.exawizards2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 計算結果が実際のサンプル結果と異なる
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int q = scanner.nextInt();
			scanner.nextLine();
			String s = scanner.nextLine();
			Map<String, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				String substring = String.valueOf(s.charAt(i));
				List<Integer> list = map.get(substring);
				if (null == list) {
					list = new ArrayList<>();
					map.put(substring, list);
				}
				list.add(i + 1);
			}
			int result = n;
			for (int i = 0; i < q; i++) {
				String t = scanner.next();
				String d = scanner.next();
				scanner.nextLine();
				List<Integer> list = map.get(t);
				if (null != list) {
					int difference = 0;
					if ("L".equals(d)) {
						difference = -1;
					} else {
						difference = 1;
					}
					for (int j = 0; i < list.size(); i++) {
						int number = list.get(j);
						if ((number >= 1) && (number <= n)) {
							int newNumber = number + difference;
							list.set(i, newNumber);
							if ((newNumber > n) || (newNumber < 1)) {
								result--;
							}
						}
					}
				}
			}
			System.out.println(result);
		}
	}
}
