package abc.abc001_050.abc021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check(5);
	}

	@Test
	void case2() {
		check(1);
	}

	private void check(int n) {
		in.input(n);
		execute();
		String[] lines = out.toString().split("\\R");
		assertTrue(lines.length > 1, lines.length + " lines only");
		Set<Integer> set = Set.of(1, 2, 4, 8);
		try {
			int k = Integer.parseInt(lines[0]);
			assertEquals(k + 1, lines.length);
		} catch (NumberFormatException e) {
			fail(lines[0] + " is not a number.");
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int k = scanner.nextInt();
			int sum = IntStream.range(0, k).map(i -> {
				int a = scanner.nextInt();
				assertTrue(set.contains(a));
				return a;
			}).sum();
			assertEquals(n, sum);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
