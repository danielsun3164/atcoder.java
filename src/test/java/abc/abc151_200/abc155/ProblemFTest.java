package abc.abc151_200.abc155;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

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
		assertTrue(lines.length >= 1, "lines.length=" + lines.length);
		int tk = Integer.parseInt(lines[0]);
		if (tk > 0) {
			assertEquals(2, lines.length);
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
				TreeMap<Integer, Integer> sumMap = new TreeMap<>(), indexMap = new TreeMap<>();
				IntStream.range(0, n).forEach(i -> sumMap.put(a[i], 0));
				IntStream.range(0, n).forEach(i -> indexMap.put(a[i], i));
				// sumMap.put(0, 0);
				// map.put(ProblemF.INF, 0);
				Arrays.stream(c).forEach(ci -> {
					Integer key = sumMap.ceilingKey(l[ci]);
					sumMap.put(key, sumMap.get(key) + 1);
					key = sumMap.higherKey(r[ci]);
					if (null != key) {
						sumMap.put(key, sumMap.get(key) - 1);
					}
				});
				Integer prevKey = null;
				for (Integer key : sumMap.keySet()) {
					if (null != prevKey) {
						sumMap.put(key, sumMap.get(key) + sumMap.get(prevKey));
					}
					if (1 == (1 & sumMap.get(key))) {
						b[indexMap.get(key)] = 1 - b[indexMap.get(key)];
					}
					prevKey = key;
				}
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

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC155/F", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
			int k = expectedScanner.nextInt();
			if (-1 == k) {
				check(inputIs, "-1");
			} else {
				int n = inputScanner.nextInt(), m = inputScanner.nextInt();
				int[] a = new int[n], b = new int[n], l = new int[m], r = new int[m];
				IntStream.range(0, n).forEach(i -> {
					a[i] = inputScanner.nextInt();
					b[i] = inputScanner.nextInt();
				});
				IntStream.range(0, m).forEach(i -> {
					l[i] = inputScanner.nextInt();
					r[i] = inputScanner.nextInt();
				});
				check(n, m, a, b, l, r);
			}
		}
	}
}
