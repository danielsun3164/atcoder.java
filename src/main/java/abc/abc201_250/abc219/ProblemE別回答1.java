package abc.abc201_250.abc219;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc219/submissions/25954916 を参考に作成
 */
public class ProblemE別回答1 {

	/** 行列の数 */
	private static final int N = 4;
	/** X座標の差分 */
	private static final int[] XS = { 1, -1, 0, 0 };
	/** Y座標の差分 */
	private static final int[] YS = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[][] a = new int[N][N];
			IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> a[i][j] = scanner.nextInt()));
			int n = N * N, end = 1 << n, answer = 0;
			label: for (int k = 1; k < end; k++) {
				int[][] b = new int[N][N];
				for (int j = 0; j < n; j++) {
					b[j / N][j % N] = 1 & (k >> j);
				}
				int count = 0, s = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if ((1 == a[i][j]) && (0 == b[i][j])) {
							continue label;
						}
						if (1 == b[i][j]) {
							count++;
							s = i * N + j;
						}
					}
				}
				boolean[][] d = new boolean[N][N];
				IntStream.range(0, N).forEach(i -> Arrays.fill(d[i], false));
				Queue<Integer> que = new ArrayDeque<>();
				que.add(s);
				d[s / N][s % N] = true;
				int count2 = 1;
				while (!que.isEmpty()) {
					int now = que.poll();
					int cx = now / N, cy = now % N;
					for (int i = 0; i < N; i++) {
						int nx = cx + XS[i], ny = cy + YS[i];
						if ((nx >= 0) && (nx < N) && (ny >= 0) && (ny < N) && (1 == b[nx][ny]) && !d[nx][ny]) {
							que.add(nx * N + ny);
							d[nx][ny] = true;
							count2++;
						}
					}
				}
				if (count == count2) {
					for (int i = 1; i <= 2; i++) {
						for (int j = 1; j <= 2; j++) {
							if (!d[i][j]) {
								boolean flag = false;
								boolean[][] e = new boolean[N][N];
								IntStream.range(0, N).forEach(l -> Arrays.fill(e[l], false));
								que.clear();
								e[i][j] = true;
								que.add(i * N + j);
								label2: while (!que.isEmpty()) {
									int now = que.poll();
									int cx = now / N, cy = now % N;
									for (int x = 0; x < N; x++) {
										int nx = cx + XS[x], ny = cy + YS[x];
										if ((nx < 0) || (nx >= N) || (ny < 0) || (ny >= N) || (1 == b[nx][ny])) {
											continue;
										}
										if ((0 == nx) || (N - 1 == nx) || (0 == ny) || (N - 1 == ny)) {
											flag = true;
											break label2;
										}
										if (!e[nx][ny]) {
											que.add(nx * N + ny);
											e[nx][ny] = true;
										}
									}
								}
								if (!flag) {
									continue label;
								}
							}
						}
					}
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}
