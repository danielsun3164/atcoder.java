package abc.abc126;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check(3, new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 1 });
	}

	@Test
	void case2() {
		check(5, new int[] { 2, 2, 1, 3 }, new int[] { 5, 3, 3, 4 }, new int[] { 2, 10, 8, 2 });
	}

	void check(int n, int[] u, int[] v, int[] w) {
		in.input(n);
		IntStream.range(0, n - 1).forEach(i -> in.input(u[i] + " " + v[i] + " " + w[i]));
		long[][] distances = new long[n][n];
		IntStream.range(0, n).forEach(i -> Arrays.fill(distances[i], Long.MAX_VALUE >> 1));
		IntStream.range(0, n).forEach(i -> distances[i][i] = 0);
		IntStream.range(0, n - 1).forEach(i -> distances[u[i] - 1][v[i] - 1] = distances[v[i] - 1][u[i] - 1] = w[i]);
		IntStream.range(0, n).forEach(k -> IntStream.range(0, n).forEach(j -> IntStream.range(0, n).forEach(i -> {
			if (distances[i][k] + distances[k][j] > distances[i][j]) {
				distances[i][j] = distances[i][k] + distances[k][j];
			}
		})));
		ProblemD.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int[] answer = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] whites = Arrays.stream(answer).filter(i -> (0 == i)).toArray();
			IntStream.range(0, whites.length - 1).forEach(i -> IntStream.range(i + 1, whites.length)
					.forEach(j -> assertEquals(0, 1 & distances[whites[i]][whites[j]])));
			int[] blacks = Arrays.stream(answer).filter(i -> (1 == i)).toArray();
			IntStream.range(0, blacks.length - 1).forEach(i -> IntStream.range(i + 1, blacks.length)
					.forEach(j -> assertEquals(0, 1 & distances[blacks[i]][blacks[j]])));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
