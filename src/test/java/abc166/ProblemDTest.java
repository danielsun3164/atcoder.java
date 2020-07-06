package abc166;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() throws IOException {
		check(33);
	}

	@Test
	void case2() throws IOException {
		check(1);
	}

	private void check(int x) throws IOException {
		in.input(x);
		ProblemD.main(null);
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			long a = scanner.nextLong(), b = scanner.nextLong();
			assertEquals(x, a * a * a * a * a - b * b * b * b * b);
		}
	}
}
