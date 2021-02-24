package abc.abc001_050.abc006;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check(3, 9);
	}

	private void check(int n, int m) {
		in.input(n + " " + m);
		ProblemC.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int a1 = scanner.nextInt(), a2 = scanner.nextInt(), a3 = scanner.nextInt();
			assertEquals(n, a1 + a2 + a3);
			assertEquals(m, a1 * 2 + a2 * 3 + a3 * 4);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@Test
	void case2() {
		check(7, 23);
	}

	@Test
	void case3() {
		check("10 41", "-1 -1 -1");
	}
}
