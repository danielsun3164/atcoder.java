package abc.abc151_200.abc188;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data[] datas = new Data[1 << n];
			IntStream.range(0, 1 << n).forEach(i -> datas[i] = new Data(scanner.nextInt(), i + 1));
			Data result = solve(datas);
			System.out.println(result.index);
		}
	}

	private static Data solve(Data[] datas) {
		int n = datas.length;
		if (2 == n) {
			if (datas[0].value > datas[1].value) {
				return datas[1];
			} else {
				return datas[0];
			}
		}
		Data[] result = new Data[n >> 1];
		IntStream.range(0, n >> 1).forEach(
				i -> result[i] = (datas[2 * i].value > datas[2 * i + 1].value) ? datas[2 * i] : datas[2 * i + 1]);
		return solve(result);
	}

	private static class Data {
		int value, index;

		Data(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}
	}
}
