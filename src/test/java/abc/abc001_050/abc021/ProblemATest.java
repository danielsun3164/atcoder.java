package abc.abc001_050.abc021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() throws IOException {
		check(5);
	}

	@Test
	void case2() throws IOException {
		check(1);
	}

	private void check(int n) throws IOException {
		in.input(n);
		ProblemA.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int number = scanner.nextInt();
			int sum = IntStream.range(0, number).map(i -> scanner.nextInt()).sum();
			assertEquals(n, sum);
		}
	}
}
