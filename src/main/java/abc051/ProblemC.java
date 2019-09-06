package abc051;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	private static final char UP = 'U';
	private static final char DOWN = 'D';
	private static final char LEFT = 'L';
	private static final char RIGHT = 'R';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int sx = scanner.nextInt();
			int sy = scanner.nextInt();
			int tx = scanner.nextInt();
			int ty = scanner.nextInt();
			int x = tx - sx, y = ty - sy;
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, y).forEach(i -> sb.append(UP));
			IntStream.range(0, x).forEach(i -> sb.append(RIGHT));
			IntStream.range(0, y).forEach(i -> sb.append(DOWN));
			IntStream.range(0, x).forEach(i -> sb.append(LEFT));
			sb.append(LEFT);
			IntStream.range(0, y + 1).forEach(i -> sb.append(UP));
			IntStream.range(0, x + 1).forEach(i -> sb.append(RIGHT));
			sb.append(DOWN);
			sb.append(RIGHT);
			IntStream.range(0, y + 1).forEach(i -> sb.append(DOWN));
			IntStream.range(0, x + 1).forEach(i -> sb.append(LEFT));
			sb.append(UP);
			System.out.println(sb.toString());
		}
	}
}
