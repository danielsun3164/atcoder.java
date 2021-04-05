package abc.abc101_150.abc146;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemA {

	private static final Map<String, Integer> map = new HashMap<>();
	static {
		map.put("SAT", 1);
		map.put("FRI", 2);
		map.put("THU", 3);
		map.put("WED", 4);
		map.put("TUE", 5);
		map.put("MON", 6);
		map.put("SUN", 7);
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(map.get(scanner.next()));
		}
	}
}
