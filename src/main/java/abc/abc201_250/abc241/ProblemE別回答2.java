package abc.abc201_250.abc241;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/3489 の実装
 */
public class ProblemE別回答2 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(_ -> scanner.nextInt()).toArray();
			// currentTime は現在の操作回数、currentCandy は現在のアメの数
			long currentTime = 0, currentCandy = 0;
			long[] lastTime = new long[n], lastCandy = new long[n];
			Arrays.fill(lastTime, -1L);
			Arrays.fill(lastCandy, -1L);

			// 手順 1: (u1, u2) を求める
			// cycleCandy は 1 周期ごとに追加されるアメの数
			long u1 = 0L, u2 = 0L, cycleCandy = 0L;
			while (true) {
				// 周期性が見つかる前に K 回目になってしまった
				if (currentTime == k) {
					System.out.println(currentCandy);
					return;
				}
				// 周期性が見つかった
				if (lastTime[(int) (currentCandy % n)] != -1) {
					u1 = lastTime[(int) (currentCandy % n)];
					u2 = currentTime;
					cycleCandy = currentCandy - lastCandy[(int) (currentCandy % n)];
					break;
				}
				// シミュレーション
				lastTime[(int) (currentCandy % n)] = currentTime;
				lastCandy[(int) (currentCandy % n)] = currentCandy;
				currentTime++;
				currentCandy += a[(int) (currentCandy % n)];
			}

			// 手順 2: ギリギリまでを高速に求める
			// maximumCycles は最大何周期分まで追加して良いか
			// finalTime はギリギリまで考えたときに何回分の操作を終えたか
			// finalCandy はギリギリまで考えたときに何個のアメを追加したか
			long maximumCycles = (k - u2) / (u2 - u1);
			long finalTime = u2 + maximumCycles * (u2 - u1), finalCandy = currentCandy + maximumCycles * cycleCandy;
			// 手順 3: 最後はシミュレーション
			while (finalTime < k) {
				finalTime++;
				finalCandy += a[(int) (finalCandy % n)];
			}
			// 出力
			System.out.println(finalCandy);
		}
	}
}
