package abc.abc201_250.abc243;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			Set<Integer> set = Arrays.stream(b).boxed().collect(Collectors.toSet());
			int ans1 = (int) IntStream.range(0, n).filter(i -> a[i] == b[i]).count();
			int ans2 = (int) IntStream.range(0, n).filter(i -> set.contains(a[i])).count();
			System.out.println(ans1);
			System.out.println(ans2 - ans1);
		}
	}
}
