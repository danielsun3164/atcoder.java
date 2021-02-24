package abc.abc151_200.abc166;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check(33);
	}

	@Test
	void case2() {
		check(1);
	}

	private void check(int x) {
		in.input(x);
		ProblemD.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			long a = scanner.nextLong(), b = scanner.nextLong();
			assertEquals(x, a * a * a * a * a - b * b * b * b * b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
