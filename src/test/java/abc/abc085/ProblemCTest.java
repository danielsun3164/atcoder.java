package abc.abc085;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws IOException {
		check(9, 45000);
	}

	@Test
	void case2() {
		check("20 196000", "-1 -1 -1");
	}

	@Test
	void case3() throws IOException {
		check(1000, 1234000);
	}

	@Test
	void case4() {
		check("2000 20000000", "2000 0 0");
	}

	private void check(int n, int y) throws IOException {
		in.input(n + " " + y);
		ProblemC.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			assertEquals(n, a + b + c);
			assertEquals(y, a * 10000 + b * 5000 + c * 1000);
		}
	}
}
