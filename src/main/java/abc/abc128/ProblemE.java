package abc.abc128;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * 結果を一行ずつSystem.out.printlnでは遅くなるため、StringBuilderで組み立ててからprintする
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> {
				int s = scanner.nextInt(), t = scanner.nextInt(), x = scanner.nextInt();
				return new Data(s - x, t - x, x);
			}).sorted((x, y) -> Integer.compare(x.x, y.x)).toArray(Data[]::new);
			SortedMap<Integer, Integer> map = new TreeMap<>();
			IntStream.range(0, q).forEach(i -> map.put(scanner.nextInt(), i));
			int[] result = new int[q];
			Arrays.fill(result, -1);
			for (Data data : datas) {
				SortedMap<Integer, Integer> subMap = map.subMap(data.s, data.t);
				subMap.entrySet().stream().forEach(entry -> result[entry.getValue()] = data.x);
				subMap.clear();
				if (map.isEmpty()) {
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			Arrays.stream(result).forEach(i -> sb.append(i).append("\n"));
			System.out.print(sb.toString());
		}
	}

	/**
	 * s,t,xを表すクラス
	 */
	private static class Data {
		/** 工事開始時間 */
		int s;
		/** 工事終了時間 */
		int t;
		/** 工事座標 */
		int x;

		Data(int s, int t, int x) {
			super();
			this.s = s;
			this.t = t;
			this.x = x;
		}
	}
}
