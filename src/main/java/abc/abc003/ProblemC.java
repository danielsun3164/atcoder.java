package abc.abc003;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] r = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(Arrays.stream(r).sorted().skip(n - k).mapToObj(BigDecimal::new).reduce(BigDecimal.ZERO,
					(accum, value) -> accum.add(value).divide(BigDecimal.valueOf(2), k, RoundingMode.HALF_UP)));
		}
	}
}
