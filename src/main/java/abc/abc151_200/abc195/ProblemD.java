package abc.abc151_200.abc195;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(scanner.nextInt(), scanner.nextInt()))
					.sorted((a, b) -> Integer.compare(a.w, b.w)).toArray(Data[]::new);
			int[] x = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			for (int i = 0; i < q; i++) {
				int l = scanner.nextInt() - 1, r = scanner.nextInt();
				List<Integer> w = Arrays.stream(datas).map(data -> data.w).collect(Collectors.toList());
				List<Integer> v = Arrays.stream(datas).map(data -> data.v).collect(Collectors.toList());
				long answer = 0L;
				int[] nx = IntStream.range(0, m).filter(j -> (j < l) || (j >= r)).map(j -> x[j]).sorted().toArray();
				if (nx.length > 0) {
					for (int nxj : nx) {
						int maxIndex = -1, maxV = 0;
						for (int k = 0; k < v.size(); k++) {
							if (w.get(k) > nxj) {
								break;
							}
							if (v.get(k) > maxV) {
								maxV = v.get(k);
								maxIndex = k;
							}
						}
						if (maxIndex >= 0) {
							answer += maxV;
							w.remove(maxIndex);
							v.remove(maxIndex);
							if (w.isEmpty()) {
								break;
							}
						}
					}
				}
				System.out.println(answer);
			}
		}
	}

	private static class Data {
		int w, v;

		Data(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
}
