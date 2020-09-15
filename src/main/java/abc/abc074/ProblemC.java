package abc.abc074;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			int c = scanner.nextInt(), d = scanner.nextInt();
			int e = scanner.nextInt(), f = scanner.nextInt();
			// 水の組合せ
			Set<Integer> waters = new HashSet<>();
			IntStream.range(0, f / a / 100 + 1)
					.forEach(i -> IntStream.range(0, (f - 100 * a * i) / b / 100 + 1).forEach(j -> {
						int water = 100 * a * i + 100 * b * j;
						if ((water <= f) && (water > 0)) {
							waters.add(water);
						}
					}));
			// 砂糖の組合せ
			Set<Integer> sugars = new HashSet<>();
			IntStream.range(0, (f - a) / c).forEach(i -> IntStream.range(0, (f - a - i) / d).forEach(j -> {
				int sugar = c * i + d * j;
				if ((sugar <= (f - a))) {
					sugars.add(sugar);
				}
			}));
			double maxRatio = -0.1d;
			int maxWater = 0, maxSugar = 0;
			for (int water : waters) {
				for (int sugar : sugars) {
					if ((water + sugar) <= f) {
						double radio = calcRadio(water, sugar, e);
						if (radio > maxRatio) {
							maxRatio = radio;
							maxWater = water;
							maxSugar = sugar;
						}
					}
				}
			}
			System.out.println((maxWater + maxSugar) + " " + maxSugar);
		}
	}

	/**
	 * @param water    水の量
	 * @param sugar    砂糖の量
	 * @param maxRadio 最大濃度
	 * @return 現在の濃度（最大濃度を超えた場合は0）
	 */
	private static double calcRadio(int water, int sugar, int maxRadio) {
		int maxSugar = water / 100 * maxRadio;
		if (sugar > maxSugar) {
			return 0.0d;
		} else {
			return 100.0 * sugar / water;
		}
	}
}
