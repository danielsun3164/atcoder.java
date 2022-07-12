package abc.abc151_200.abc165;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check(4, 1);
	}

	@Test
	void case2() {
		check(7, 3);
	}

	void check(int n, int m) {
		in.input(n + " " + m);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(m, lines.length);
		Arrays.stream(lines).forEach(line -> {
			String[] numbers = line.split("\\ ");
			assertEquals(2, numbers.length);
		});
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int[] a = new int[m], b = new int[m];
			Set<Integer> resultSet = new HashSet<>(), diffSet = new HashSet<>();
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt();
				assertTrue((a[i] >= 1) && (a[i] <= n), "a[" + i + "] is " + a[i]);
				assertFalse(resultSet.contains(a[i]));
				resultSet.add(a[i]);
				b[i] = scanner.nextInt();
				assertTrue((b[i] >= 1) && (b[i] <= n), "b[" + i + "] is " + b[i]);
				assertFalse(resultSet.contains(b[i]));
				resultSet.add(b[i]);
				assertFalse(diffSet.contains(Math.abs(a[i] - b[i])));
				diffSet.add(Math.abs(a[i] - b[i]));
			});
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC165/E", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner scanner = new Scanner(inputIs)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			check(n, m);
		}
	}
}
