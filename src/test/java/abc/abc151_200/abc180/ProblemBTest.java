package abc.abc151_200.abc180;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	private static final double TOLERANCE = 1E-9d;

	@Test
	void case1() throws IOException {
		in.input("2\n" + "2 -1");
		ProblemB.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			assertEquals("3", scanner.next());
			double e = scanner.nextDouble();
			assertTrue(Math.abs(e - 2.236067977499790d) < TOLERANCE, "e is " + e);
			assertEquals("2", scanner.next());
		}
	}

	@Test
	void case2() throws IOException {
		in.input("10\n" + "3 -1 -4 1 -5 9 2 -6 5 -3");
		ProblemB.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			assertEquals("39", scanner.next());
			double e = scanner.nextDouble();
			assertTrue(Math.abs(e - 14.387494569938159d) < TOLERANCE, "e is " + e);
			assertEquals("9", scanner.next());
		}
	}
}
