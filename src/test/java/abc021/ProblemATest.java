package abc021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import practice.TestBase;

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
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			int number = scanner.nextInt();
			int sum = IntStream.range(0, number).map(i -> scanner.nextInt()).sum();
			assertEquals(n, sum);
		}
	}
}
