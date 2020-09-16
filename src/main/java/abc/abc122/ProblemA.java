package abc.abc122;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemA {

	/** 変換用マップ */
	private static final Map<String, String> MAP = new HashMap<>();
	static {
		MAP.put("A", "T");
		MAP.put("T", "A");
		MAP.put("C", "G");
		MAP.put("G", "C");
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(MAP.get(s));
		}
	}
}
