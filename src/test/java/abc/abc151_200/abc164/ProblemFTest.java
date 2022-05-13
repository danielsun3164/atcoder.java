package abc.abc151_200.abc164;

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
		check(2, new int[] { 0, 1 }, new int[] { 1, 0 }, new long[] { 1L, 1L }, new long[] { 1L, 0L });
	}

	@Test
	void case2() {
		check(2, new int[] { 1, 1 }, new int[] { 1, 0 }, new long[] { 15L, 15L }, new long[] { 15L, 11L });
	}

	void check(int n, int[] s, int[] t, long[] u, long[] v) {
		in.input(n);
		in.input(Arrays.stream(s).mapToObj(si -> String.valueOf(si)).collect(Collectors.joining(" ")));
		in.input(Arrays.stream(t).mapToObj(si -> String.valueOf(si)).collect(Collectors.joining(" ")));
		in.input(Arrays.stream(u).mapToObj(si -> String.valueOf(si)).collect(Collectors.joining(" ")));
		in.input(Arrays.stream(v).mapToObj(si -> String.valueOf(si)).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(n, lines.length);
		Arrays.stream(lines).forEach(line -> {
			String[] numbers = line.split("\\ ");
			assertEquals(n, numbers.length);
		});
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			long[][] a = new long[n][n];
			IntStream.range(0, n)
					.forEach(i -> IntStream.range(0, n).forEach(j -> a[i][j] = Long.parseUnsignedLong(scanner.next())));
			IntStream.range(0, n).forEach(i -> {
				if (0 == s[i]) {
					assertEquals(u[i], IntStream.range(0, n).mapToLong(j -> a[i][j]).reduce(-1L, (x, ai) -> x & ai));
				} else {
					assertEquals(u[i], IntStream.range(0, n).mapToLong(j -> a[i][j]).reduce(0L, (x, ai) -> x | ai));
				}
				if (0 == t[i]) {
					assertEquals(v[i], IntStream.range(0, n).mapToLong(j -> a[j][i]).reduce(-1L, (x, ai) -> x & ai));
				} else {
					assertEquals(v[i], IntStream.range(0, n).mapToLong(j -> a[j][i]).reduce(0L, (x, ai) -> x | ai));
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
