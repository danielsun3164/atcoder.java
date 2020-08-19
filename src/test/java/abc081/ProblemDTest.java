package abc081;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() throws IOException {
		check(new int[] { -2, 5, -1 });
	}

	@Test
	void case2() throws IOException {
		check(new int[] { -1, -3 });
	}

	@Test
	void case3() {
		check("5\n" + "0 0 0 0 0", "0");
	}

	private void check(int[] a) throws IOException {
		in.input(a.length);
		in.input(Arrays.stream(a).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(" ")));
		ProblemD.main(null);
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			int n = scanner.nextInt();
			IntStream.range(0, n).forEach(i -> {
				int x = scanner.nextInt() - 1;
				a[scanner.nextInt() - 1] += a[x];
			});
			assertTrue(ProblemD.isIncreasing(a));
		}
	}
}
