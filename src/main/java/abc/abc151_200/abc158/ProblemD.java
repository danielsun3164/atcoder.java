package abc.abc151_200.abc158;

import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder sb = new StringBuilder(scanner.next()), prefix = new StringBuilder();
			int q = scanner.nextInt();
			boolean reverse = false;
			for (int i = 0; i < q; i++) {
				int t = scanner.nextInt();
				if (1 == t) {
					reverse = !reverse;
				} else {
					int f = scanner.nextInt();
					String c = scanner.next();
					f = reverse ? 3 - f : f;
					if (1 == f) {
						prefix.append(c);
					} else {
						sb.append(c);
					}
				}
			}
			System.out.println((reverse ? sb.reverse().append(prefix) : prefix.reverse().append(sb)).toString());
		}
	}
}
