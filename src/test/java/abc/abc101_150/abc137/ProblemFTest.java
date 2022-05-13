package abc.abc101_150.abc137;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check(new int[] { 1, 0 });
	}

	@Test
	void case2() {
		check(new int[] { 0, 0, 0 });
	}

	@Test
	void case3() {
		check(new int[] { 0, 1, 0, 1, 0 });
	}

	private void check(int[] a) {
		int p = a.length;
		in.input(p);
		in.input(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		String[] numbers = lines[0].split("\\ ");
		assertEquals(p, numbers.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int[] b = IntStream.range(0, p).map(i -> scanner.nextInt()).toArray();
			IntStream.range(0, p).forEach(i -> assertEquals(a[i], func(b, i, p)));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * 多項式の値 mod pを計算する
	 *
	 * @param b 多項式の係数の配列
	 * @param x xの値
	 * @param p
	 * @return 多項式の値 mod p
	 */
	private int func(final int[] b, int x, int p) {
		return IntStream.range(0, p).reduce(0, (s, i) -> (s + b[i] * powMod(x, i, p) % p) % p);
	}

	/**
	 * n^m mod p を計算する
	 *
	 * @param n
	 * @param m
	 * @param p
	 * @return n^m mod p
	 */
	private int powMod(int n, int m, int p) {
		int result = 1;
		while (m > 0) {
			if (1 == (1 & m)) {
				result = result * n % p;
			}
			n = n * n % p;
			m >>= 1;
		}
		return result;
	}
}
