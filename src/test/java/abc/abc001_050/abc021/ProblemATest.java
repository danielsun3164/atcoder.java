package abc.abc001_050.abc021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;
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
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int k = scanner.nextInt();
			int sum = IntStream.range(0, k).map(i -> scanner.nextInt()).sum();
			assertEquals(n, sum);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
