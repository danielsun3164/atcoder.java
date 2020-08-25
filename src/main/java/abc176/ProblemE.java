package abc176;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int h = scanner.nextInt(), w = scanner.nextInt(), m = scanner.nextInt();
			Map<Masu, Boolean> bombMap = new HashMap<>();
			// 毎行、毎列それぞれの爆破対象の数を保存するマップ
			Map<Integer, Integer> xCountMap = new HashMap<>(), yCountMap = new HashMap<>();
			IntStream.range(0, m).forEach(i -> {
				int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
				bombMap.put(new Masu(x, y), true);
				xCountMap.put(x, xCountMap.getOrDefault(x, 0) + 1);
				yCountMap.put(y, yCountMap.getOrDefault(y, 0) + 1);
			});
			// 一行の爆破対象の数の最大値
			int xCountMax = xCountMap.values().stream().mapToInt(Integer::intValue).max().getAsInt();
			// 一列の爆破対象の数の最大値
			int yCountMax = yCountMap.values().stream().mapToInt(Integer::intValue).max().getAsInt();
			List<Entry<Integer, Integer>> xCountEntries = xCountMap.entrySet().stream()
					.filter(entry -> xCountMax == entry.getValue()).collect(Collectors.toList());
			List<Entry<Integer, Integer>> yCountEntries = yCountMap.entrySet().stream()
					.filter(entry -> yCountMax == entry.getValue()).collect(Collectors.toList());
			for (Entry<Integer, Integer> xCountEntry : xCountEntries) {
				for (Entry<Integer, Integer> yCountEntry : yCountEntries) {
					if (null == bombMap.get(new Masu(xCountEntry.getKey(), yCountEntry.getKey()))) {
						// 該当のマスに爆破対象がない場合
						System.out.println(xCountMax + yCountMax);
						return;
					}
				}
			}
			// どのマスにも爆破対象がある場合
			System.out.println(xCountMax + yCountMax - 1);
		}
	}

	/**
	 * マスを表すクラス
	 */
	private static class Masu {
		int x;
		int y;

		Masu(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Masu) {
				Masu data = (Masu) o;
				return (x == data.x) && (y == data.y);
			}
			return false;
		}
	}
}
