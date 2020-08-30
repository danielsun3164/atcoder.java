package abc096;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	private final static Set<Integer> primeSet = new HashSet<>();

	@BeforeAll
	static void init() {
		boolean[] isPrime = new boolean[ProblemD.MAX + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i <= ProblemD.MAX; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j <= ProblemD.MAX; j += i) {
					isPrime[j] = false;
				}
			}
		}
		IntStream.range(2, ProblemD.MAX).filter(i -> isPrime[i]).forEach(i -> primeSet.add(i));
	}

	@Test
	void case1() throws IOException {
		check(5);
	}

	@Test
	void case2() throws IOException {
		check(6);
	}

	@Test
	void case3() throws IOException {
		check(8);
	}

	private void check(int n) throws IOException {
		in.input(n);
		ProblemD.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int[] answers = new int[n];
			IntStream.range(0, n).forEach(i -> answers[i] = scanner.nextInt());
			IntStream.range(0x1F, 1 << n).filter(i -> Integer.bitCount(i) == ProblemD.N)
					.map(i -> IntStream.range(0, n).filter(j -> (i & (1 << j)) > 0).map(j -> answers[j]).sum())
					.forEach(i -> {
						assertEquals(0, i % 5);
						assertEquals(false, primeSet.contains(i));
					});
		}
	}
}
