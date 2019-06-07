package abc004;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	private static final int RED = -100;
	private static final int GREEN = 0;
	private static final int BLUE = 100;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt();
			int g = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(IntStream.range(-1000, 1000).map(i -> getResult(i, r, g, b)).min().getAsInt());
		}
	}

	/**
	 * @param place 緑の一番左の置き場所
	 * @param r     赤の個数
	 * @param g     緑の個数
	 * @param b     青の個数
	 * @return 移動数
	 */
	private static int getResult(int place, final int r, final int g, final int b) {
		return calcR(place - 1, r) + calcG(place, g) + calcB(place + g, b);
	}

	/**
	 * @param place 赤のマーブルが置ける一番右の場所（置かなければならないことはない）
	 * @param r     赤のマーブルの個数
	 * @return 赤のマーブルの移動数
	 */
	private static int calcR(int place, final int r) {
		if (place <= RED) {
			return (RED - place) * r + sum(r, true);
		} else {
			int r1 = Math.min(place - RED, r / 2);
			return sum(r1, false) + sum(r - r1, true);
		}
	}

	/**
	 * @param place 緑のマーブルが置く一番左の場所
	 * @param g     緑のマーブルの個数
	 * @return 緑のマーブルの移動数
	 */
	private static int calcG(int place, final int g) {
		if (place >= GREEN) {
			return (place - GREEN) * g + sum(g, true);
		} else if ((place + g - 1) < GREEN) {
			return (GREEN - (place + g - 1)) * g + sum(g, true);
		} else {
			int g1 = GREEN - place;
			return sum(g1, false) + sum(g - g1, true);
		}
	}

	/**
	 * @param place 青のマーブルが置く一番左の場所（置かなければならないことはない）
	 * @param b     青のマーブルの個数
	 * @return 青のマーブルの移動数
	 */
	private static int calcB(int place, final int b) {
		if (place > BLUE) {
			return (place - BLUE) * b + sum(b, true);
		} else {
			int b1 = Math.min(BLUE - place, b / 2);
			return sum(b1, false) + sum(b - b1, true);
		}
	}

	/**
	 * @param number  マープルの数
	 * @param include 現在の箱を含むかどうか
	 * @return 片方向にマーブルの数をばらまく移動数
	 */
	private static int sum(int number, boolean include) {
		if (include) {
			return number * (number - 1) / 2;
		} else {
			return number * (number + 1) / 2;
		}
	}
}
