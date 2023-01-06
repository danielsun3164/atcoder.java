package other.typical90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * TLE対策のため、以下のことを実施
 * <ul>
 * <li>Scannerの代わりにInputStreamReaderとBufferedReaderで入力を読み取る</li>
 * <li>System.out.printlnの代わりに、StringBuilderを使用する</li>
 * </ul>
 */
public class Problem004 {

	public static void main(String[] args) {
		try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr)) {
			String[] strings = br.readLine().split("\\s+");
			int h = Integer.parseInt(strings[0]), w = Integer.parseInt(strings[1]);
			int[][] a = new int[h][w];
			int[] sumW = new int[h], sumH = new int[w];
			Arrays.fill(sumW, 0);
			Arrays.fill(sumH, 0);
			for (int i = 0; i < h; i++) {
				String[] ss = br.readLine().split("\\s+");
				for (int j = 0; j < w; j++) {
					a[i][j] = Integer.parseInt(ss[j]);
					sumW[i] += a[i][j];
					sumH[j] += a[i][j];
				}
			}
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, h).forEach(i -> {
				IntStream.range(0, w).forEach(j -> {
					if (j > 0) {
						sb.append(" ");
					}
					sb.append(((sumW[i] + sumH[j]) - a[i][j]));
				});
				sb.append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
