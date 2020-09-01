package other.past201912;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			List<String> list = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for (char c : s) {
				sb.append(c);
				if ((c >= 'A') && (c <= 'Z')) {
					count++;
					if (count >= 2) {
						list.add(sb.toString());
						sb.setLength(0);
						count = 0;
					}
				}
			}
			System.out.println(list.stream().sorted((x, y) -> x.compareToIgnoreCase(y)).collect(Collectors.joining()));
		}
	}
}
