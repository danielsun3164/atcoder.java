package other.typical90;

import java.util.Scanner;

public class Problem033 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			System.out.println(((1 == h) || (1 == w)) ? h * w : ((h + 1) >> 1) * ((w + 1) >> 1));
		}
	}
}
