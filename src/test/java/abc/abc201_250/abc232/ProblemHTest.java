package abc.abc201_250.abc232;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check(3, 2, 3, 2);
	}

	void check(int h, int w, int a, int b) {
		in.input(h + " " + w + " " + a + " " + b);
		execute();
		String[] strings = out.toString().split("\\R");
		assertEquals(h * w, strings.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			boolean[][] visited = new boolean[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(visited[i], false));
			int preH = 0, preW = 0;
			for (int i = 0; i < h * w; i++) {
				int hi = scanner.nextInt() - 1, wi = scanner.nextInt() - 1;
				assertFalse(visited[hi][wi]);
				visited[hi][wi] = true;
				if (0 == i) {
					assertEquals(0, hi);
					assertEquals(0, wi);
				} else {
					assertTrue(Math.abs(hi - preH) <= 1);
					assertTrue(Math.abs(wi - preW) <= 1);
				}
				if (h * w - 1 == i) {
					assertEquals(a - 1, hi);
					assertEquals(b - 1, wi);
				}
				preH = hi;
				preW = wi;
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc232/H", (inputIs, outputIs) -> {
			try (Scanner scanner = new Scanner(inputIs)) {
				check(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			}
		});
	}
}
