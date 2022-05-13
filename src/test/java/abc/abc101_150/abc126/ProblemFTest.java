package abc.abc101_150.abc126;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check(1, 0);
	}

	@Test
	void case2() {
		check("1 1", "-1");
	}

	@Test
	void case3() {
		check("5 58", "-1");
	}

	@Test
	void case4() {
		check(5, 28);
	}

	@Test
	void case5() {
		check(0, 0);
	}

	private void check(int m, int k) {
		in.input(m + " " + k);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		String[] numbers = lines[0].split("\\ ");
		assertEquals(1 << (m + 1), numbers.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int max = 1 << m;
			@SuppressWarnings("unchecked")
			List<Integer>[] indexes = new List[max];
			IntStream.range(0, max).forEach(i -> indexes[i] = new ArrayList<>());
			int[] a = IntStream.range(0, max << 1).map(i -> {
				int ai = scanner.nextInt();
				assertTrue((ai >= 0) && (ai <= max), "ai is " + ai);
				indexes[ai].add(i);
				return ai;
			}).toArray();
			IntStream.range(0, max).forEach(i -> {
				assertEquals(2, indexes[i].size());
				assertEquals(k,
						IntStream.rangeClosed(indexes[i].get(0), indexes[i].get(1)).reduce(0, (xor, j) -> xor ^ a[j]));
			});
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
