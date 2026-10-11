package abc.abc201_250.abc244;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc244/editorial/3626 の実装<br/>
 * https://atcoder.jp/contests/abc244/submissions/30307939 にも参考
 */
public class ProblemEx別回答1 {
	private static final BigInteger SCALE = BigInteger.TEN.pow(20);
	private static final BigInteger INF = BigInteger.TEN.pow(50);

	public static void main(String[] args) throws Exception {

		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			Set<BigInteger> coordinates = new HashSet<>();
			BigInteger maxX = SCALE.negate(), minX = SCALE;
			// 入力を読み込み、クエリ座標を収集
			List<Input> inputs = IntStream.range(0, q).mapToObj(_ -> {
				BigInteger x = new BigInteger(scanner.next()), y = new BigInteger(scanner.next()),
						a = new BigInteger(scanner.next()), b = new BigInteger(scanner.next()), c = BigInteger.ZERO;
				if (b.signum() != 0) {
					BigInteger numerator = a.multiply(SCALE).multiply(BigInteger.TWO).add(b);
					BigInteger denominator = b.multiply(BigInteger.TWO);
					c = floorDiv(numerator, denominator);
					coordinates.add(c);
				}
				return new Input(x, y, a, b, c);
			}).toList();
			LiChaoTree lct1 = new LiChaoTree(coordinates);
			LiChaoTree lct2 = new LiChaoTree(coordinates);
			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			for (Input input : inputs) {
				BigInteger x = input.x, y = input.y, a = input.a, b = input.b, c = input.c;
				maxX = maxX.max(x);
				minX = minX.min(x);
				lct1.addLine(x.negate(), y.multiply(SCALE).negate());
				lct2.addLine(x, y.multiply(SCALE));
				BigInteger answer;
				if (b.signum() > 0) {
					BigInteger s = lct1.query(c).negate();
					BigInteger numerator = s.multiply(b).multiply(BigInteger.TWO).add(SCALE);
					BigInteger denominator = SCALE.multiply(BigInteger.TWO);
					answer = floorDiv(numerator, denominator);
				} else if (b.signum() < 0) {
					BigInteger s = lct2.query(c);
					BigInteger numerator = s.multiply(b).multiply(BigInteger.TWO).add(SCALE);
					BigInteger denominator = SCALE.multiply(BigInteger.TWO);
					answer = floorDiv(numerator, denominator);
				} else {
					answer = maxX.multiply(a).max(minX.multiply(a));
				}
				// Pythonのround(ans)に相当。
				// ansは整数除算で得た整数なので、そのまま出力する。
				sb.append(answer).append(System.lineSeparator());
			}
			System.out.print(sb);
			System.out.flush();
		}
	}

	/**
	 * Pythonの // と同じ床除算。 BigInteger.divide() は0方向への切り捨てなので補正する。
	 */
	private static BigInteger floorDiv(BigInteger a, BigInteger b) {
		BigInteger[] qr = a.divideAndRemainder(b);
		if (qr[1].signum() != 0 && a.signum() != b.signum()) {
			return qr[0].subtract(BigInteger.ONE);
		}
		return qr[0];
	}

	/**
	 * Li Chao Tree（最小値クエリ）。
	 */
	private static class LiChaoTree {
		private final int n;
		private final List<BigInteger> x;
		private final Map<BigInteger, Integer> map;
		// 各ノードの左端・中央・右端
		private final BigInteger[][] lmr;
		// 各ノードに格納する直線 (a, b): y = ax + b
		private final BigInteger[][] f;

		LiChaoTree(Collection<BigInteger> coordinates) {
			// Stream APIで重複を除去し、昇順にソート
			List<BigInteger> sortedX = coordinates.stream().distinct().sorted().toList();

			/*
			 * Python: n = 1 << (len(X) - 1).bit_length()
			 *
			 * 空集合の場合もPythonと同じく n = 2 とする。
			 */
			int bitLength;
			if (sortedX.isEmpty()) {
				bitLength = 1;
			} else {
				bitLength = sortedX.size() == 1 ? 0 : 32 - Integer.numberOfLeadingZeros(sortedX.size() - 1);
			}

			n = 1 << bitLength;
			x = new ArrayList<>(sortedX);
			while (x.size() < n) {
				x.add(INF);
			}

			// 座標からインデックスへの対応表
			map = IntStream.range(0, sortedX.size()).boxed().collect(Collectors.toMap(sortedX::get, i -> i));
			lmr = new BigInteger[n << 1][3];

			// 葉ノードの区間
			IntStream.range(0, n).forEach(i -> Arrays.fill(lmr[n + i], x.get(i)));
			// 内部ノードの区間を構築
			IntStream.iterate(n - 1, i -> i > 0, i -> i - 1).forEach(i -> {
				lmr[i][0] = lmr[i * 2][0];
				lmr[i][1] = lmr[i * 2][2];
				lmr[i][2] = lmr[i * 2 + 1][2];
			});
			f = new BigInteger[n * 2][];
		}

		private BigInteger calc(BigInteger[] line, BigInteger x) {
			return line[0].multiply(x).add(line[1]);
		}

		/**
		 * 直線を木に追加する。
		 */
		private void update(int i, BigInteger[] line) {
			while (true) {
				BigInteger l = lmr[i][0], m = lmr[i][1], r = lmr[i][2];
				BigInteger[] fi = f[i];
				if (fi == null) {
					f[i] = line;
					return;
				}
				boolean cl = fi[0].subtract(line[0]).multiply(l).add(fi[1].subtract(line[1])).signum() > 0;
				boolean cr = fi[0].subtract(line[0]).multiply(r).add(fi[1].subtract(line[1])).signum() > 0;
				if (cl && cr) {
					f[i] = line;
					return;
				}

				if (!cl && !cr) {
					return;
				}

				if (fi[0].subtract(line[0]).multiply(m).add(fi[1].subtract(line[1])).signum() > 0) {
					f[i] = line;
					line = fi;
					cl = !cl;
				}

				if (cl) {
					i <<= 1;
				} else {
					i = (i << 1) | 1;
				}
			}
		}

		/**
		 * x における最小値を取得する。
		 */
		BigInteger query(BigInteger x) {
			int i = map.get(x) + n;
			BigInteger min = INF;
			while (i > 0) {
				if (f[i] != null) {
					min = min.min(calc(f[i], x));
				}
				i >>= 1;
			}
			return min;
		}

		/**
		 * y = ax + b を追加する。
		 */
		void addLine(BigInteger a, BigInteger b) {
			update(1, new BigInteger[] { a, b });
		}
	}

	/**
	 * x,y,a,b,cを格納するクラス
	 */
	private static class Input {
		final BigInteger x, y, a, b, c;

		Input(BigInteger x, BigInteger y, BigInteger a, BigInteger b, BigInteger c) {
			this.x = x;
			this.y = y;
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}
