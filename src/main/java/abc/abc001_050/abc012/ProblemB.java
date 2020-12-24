package abc.abc001_050.abc012;

import java.time.LocalTime;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(LocalTime.of(0, 0, 0).plusSeconds(n));
		}
	}
}
