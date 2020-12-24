package abc.abc101_150.abc111;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** wを表す正規表現 */
	private static final Pattern PATTERN = Pattern.compile("^[LRDU]+");

	@Test
	void case1() throws IOException {
		check(3, new int[] { -1, 0, 2 }, new int[] { 0, 3, -1 });
	}

	@Test
	void case2() {
		check("5\n" + "0 0\n" + "1 0\n" + "2 0\n" + "3 0\n" + "4 0", "-1");
	}

	@Test
	void case3() throws IOException {
		check(2, new int[] { 1, 1 }, new int[] { 1, 1 });
	}

	private void check(int n, int[] x, int[] y) throws IOException {
		in.input(n);
		IntStream.range(0, n).forEach(i -> in.input(x[i] + " " + y[i]));
		ProblemD.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int m = scanner.nextInt();
			int[] d = new int[m];
			IntStream.range(0, m).forEach(i -> d[i] = scanner.nextInt());
			IntStream.range(0, n).forEach(i -> {
				String w = scanner.next();
				assertEquals(m, w.length());
				assertTrue(PATTERN.matcher(w).matches(), "w is " + w);
				check(m, d, w.toCharArray(), x[i], y[i]);
			});
		}
	}

	/**
	 * 指定されたモードで関節mが(expectedX,expectedY)にあるかをチェック
	 * 
	 * @param m         腕数
	 * @param d         腕の長さの配列
	 * @param w         モード
	 * @param expectedX
	 * @param expectedY
	 */
	private void check(int m, int[] d, char[] w, int expectedX, int expectedY) {
		int x = 0, y = 0;
		for (int i = 0; i < m; i++) {
			switch (w[i]) {
			case 'L':
				x -= d[i];
				break;
			case 'R':
				x += d[i];
				break;
			case 'D':
				y -= d[i];
				break;
			default:
			case 'U':
				y += d[i];
				break;
			}
		}
		assertEquals(expectedX, x);
		assertEquals(expectedY, y);
	}
}
