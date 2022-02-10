package abc.abc151_200.abc157;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** カードの縦か横のサイズ */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Map<Integer, Integer> map = new HashMap<>();
			boolean[][] marks = new boolean[N][N];
			IntStream.range(0, N)
					.forEach(i -> IntStream.range(0, N).forEach(j -> map.put(scanner.nextInt(), i * N + j)));
			int n = scanner.nextInt();
			IntStream.range(0, n).forEach(i -> {
				int b = scanner.nextInt();
				Integer index = map.get(b);
				if (null != index) {
					marks[index / N][index % N] = true;
				}
			});
			boolean nanameResult1 = true, nanameResult2 = true;
			for (int i = 0; i < N; i++) {
				boolean tateResult = true, yokoResult = true;
				for (int j = 0; j < N; j++) {
					tateResult &= marks[j][i];
					yokoResult &= marks[i][j];
				}
				if (tateResult || yokoResult) {
					System.out.println("Yes");
					return;
				}
				nanameResult1 &= marks[i][i];
				nanameResult2 &= marks[i][N - 1 - i];
			}
			System.out.println((nanameResult1 || nanameResult2) ? "Yes" : "No");
		}
	}
}
