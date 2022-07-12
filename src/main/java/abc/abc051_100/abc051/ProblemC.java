package abc.abc051_100.abc051;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 上 */
	static final char UP = 'U';
	/** 下 */
	static final char DOWN = 'D';
	/** 左 */
	static final char LEFT = 'L';
	/** 右 */
	static final char RIGHT = 'R';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int sx = scanner.nextInt(), sy = scanner.nextInt(), tx = scanner.nextInt(), ty = scanner.nextInt();
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
