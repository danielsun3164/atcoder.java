package other.typical90;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem061 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			List<Integer> up = new ArrayList<>(), bottom = new ArrayList<>();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int t = scanner.nextInt(), x = scanner.nextInt();
				if (1 == t) {
					up.add(x);
				} else if (2 == t) {
					bottom.add(x);
				} else {
					sb.append((x > up.size()) ? bottom.get(x - up.size() - 1) : up.get(up.size() - x))
							.append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
