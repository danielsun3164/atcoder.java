package abc.abc151_200.abc155;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check(3, 4, new int[] { 5, 10, 8 }, new int[] { 1, 1, 0 }, new int[] { 1, 4, 6, 8 }, new int[] { 10, 5, 7, 9 });
	}

	private void check(int n, int m, int[] a, int[] b, int[] l, int[] r) {
		in.input(n + " " + m);
		IntStream.range(0, n).forEach(i -> in.input(a[i] + " " + b[i]));
		IntStream.range(0, m).forEach(i -> in.input(l[i] + " " + r[i]));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(2, lines.length);
		int tk = Integer.parseInt(lines[0]);
		if (tk > 0) {
			String[] numbers = lines[1].split("\\ ");
			assertEquals(tk, numbers.length);
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int k = scanner.nextInt();
			if (k > 0) {
				int[] c = IntStream.range(0, k).map(i -> {
					int ci = scanner.nextInt();
					assertTrue((ci >= 1) && (ci <= m));
					return ci - 1;
				}).toArray();
				IntStream.range(1, k).forEach(i -> assertTrue(c[i - 1] < c[i]));
				TreeMap<Integer, Integer> map = new TreeMap<>();
				IntStream.range(0, n).forEach(i -> map.put(a[i], i));
				Arrays.stream(c).forEach(ci -> {
					map.subMap(l[ci], r[ci] + 1).entrySet()
							.forEach(entry -> b[entry.getValue()] = 1 - b[entry.getValue()]);
				});
			}
			int[] expected = IntStream.range(0, n).map(i -> 0).toArray();
			assertArrayEquals(expected, b);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@Test
	void case2() {
		check("4 2\n" + "2 0\n" + "3 1\n" + "5 1\n" + "7 0\n" + "1 4\n" + "4 7", "-1");
	}

	@Test
	void case3() {
		check("3 2\n" + "5 0\n" + "10 0\n" + "8 0\n" + "6 9\n" + "66 99", "0" + LF);
	}

	@Test
	void case4() {
		check(12, 20,
				new int[] { 536130100, 150049660, 79245447, 132551741, 89484841, 328129089, 623467741, 248785745,
						421631475, 498966877, 43768791, 112237273 },
				new int[] { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0 },
				new int[] { 21499042, 58176487, 88563042, 120198276, 134867387, 211946499, 233934566, 335674184,
						414601661, 101135608, 90972258, 255474956, 436210625, 145652401, 377607297, 244404406,
						112237273, 392593015, 150586788, 54772353 },
				new int[] { 142460201, 384985131, 144788076, 497115965, 563350571, 458996604, 297258009, 555985828,
						520203502, 501051309, 300372385, 630621190, 517850028, 192476406, 520655694, 304034433,
						359737255, 463983307, 504362212, 83124235 });
	}
}
