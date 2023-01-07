package other.typical90;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem077Test extends TestBase {

	/** X座標とY座標の差分の一覧 */
	private static final int[][] DXYS = new int[][] { { 0, 1, 1, 0, -1, -1, -1, 0, 1 },
			{ 0, 0, 1, 1, 1, 0, -1, -1, -1 } };

	@Test
	void case1() {
		check(3, 2, new int[][] { { 3, 3 }, { 5, 5 }, { 9, 2 } }, new int[][] { { 11, 2 }, { 5, 5 }, { 3, 3 } });
	}

	private void check(int n, int t, int[][] a, int[][] b) {
		in.input(n + " " + t);
		IntStream.range(0, n).forEach(i -> in.input(a[i][0] + " " + a[i][1]));
		IntStream.range(0, n).forEach(i -> in.input(b[i][0] + " " + b[i][1]));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(2, lines.length);
		String[] sd = lines[1].split("\\s+");
		assertEquals(n, sd.length);
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			try {
				d[i] = Integer.parseInt(sd[i]);
				assertTrue((d[i] >= 1) && (d[i] < DXYS[0].length), "d[" + i + "] is " + d[i]);
			} catch (NumberFormatException e) {
				fail(e);
			}
		}
		int[][] c = new int[n][2];
		IntStream.range(0, n).forEach(i -> IntStream.range(0, 2).forEach(j -> c[i][j] = a[i][j] + t * DXYS[j][d[i]]));
		Arrays.sort(b, (bi, bj) -> (bi[0] == bj[0]) ? Integer.compare(bi[1], bj[1]) : Integer.compare(bi[0], bj[0]));
		Arrays.sort(c, (ci, cj) -> (ci[0] == cj[0]) ? Integer.compare(ci[1], cj[1]) : Integer.compare(ci[0], cj[0]));
		assertArrayEquals(b, c);
	}

	@Test
	void case2() {
		check("3 2\n" + "3 3\n" + "5 5\n" + "9 2\n" + "11 1000000000\n" + "5 5\n" + "3 3", "No");
	}

	@Test
	void case3() {
		check(20, 774, new int[][] { { 540130346, 269080121 }, { 139837096, 165633078 }, { 731188937, 784167460 },
				{ 18996195, 52176517 }, { 153153670, 738204723 }, { 179733158, 825294112 }, { 698198250, 713974773 },
				{ 449248931, 563096572 }, { 249863070, 242694893 }, { 428066819, 476630383 }, { 554127636, 460973490 },
				{ 389988495, 32320086 }, { 889782910, 956212985 }, { 43905938, 212030305 }, { 638141790, 667879166 },
				{ 985957895, 358743012 }, { 971007109, 827787244 }, { 804625543, 141347414 }, { 905270323, 167192824 },
				{ 614855582, 963943648 } },
				new int[][] { { 179733932, 825294886 }, { 731188163, 784166686 }, { 153154444, 738205497 },
						{ 554128410, 460973490 }, { 804626317, 141348188 }, { 449249705, 563096572 },
						{ 540129572, 269079347 }, { 638142564, 667878392 }, { 614855582, 963944422 },
						{ 18996969, 52177291 }, { 971007109, 827788018 }, { 889782910, 956213759 },
						{ 43906712, 212031079 }, { 389987721, 32319312 }, { 139836322, 165633078 },
						{ 428067593, 476631157 }, { 905271097, 167192824 }, { 249862296, 242694893 },
						{ 985958669, 358742238 }, { 698199024, 713975547 } });

	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
			String r = expectedScanner.next();
			if ("No".equals(r)) {
				check(inputIs, r);
			} else {
				int n = inputScanner.nextInt(), t = inputScanner.nextInt();
				int[][] a = new int[n][2], b = new int[n][2];
				IntStream.range(0, n)
						.forEach(i -> IntStream.range(0, 2).forEach(j -> a[i][j] = inputScanner.nextInt()));
				IntStream.range(0, n)
						.forEach(i -> IntStream.range(0, 2).forEach(j -> b[i][j] = inputScanner.nextInt()));
				check(n, t, a, b);
			}
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/077", this::check);
	}
}
