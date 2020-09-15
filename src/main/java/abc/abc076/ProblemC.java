package abc.abc076;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next(), t = scanner.next();
			StringBuilder sb = new StringBuilder();
			for (char c : t.toCharArray()) {
				sb.append("[").append(c).append("\\?]");
			}
			Matcher matcher = Pattern.compile(sb.toString()).matcher(s);
			int index = -1;
			while (matcher.find(index + 1)) {
				index = matcher.start();
			}
			if (index >= 0) {
				System.out
						.println((s.substring(0, index) + t + s.substring(index + t.length())).replaceAll("\\?", "a"));
			} else {
				System.out.println("UNRESTORABLE");
			}
		}
	}
}
