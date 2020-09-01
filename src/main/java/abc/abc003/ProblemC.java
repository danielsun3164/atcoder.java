package abc.abc003;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			List<Long> list = new ArrayList<>();
			IntStream.range(0, n).forEach(i -> list.add(scanner.nextLong()));
			System.out.println(list.stream().sorted().skip(n - k).map(BigDecimal::new).reduce(BigDecimal.ZERO,
					(accum, value) -> accum.add(value).divide(BigDecimal.valueOf(2), k, RoundingMode.HALF_UP)));
		}
	}
}
