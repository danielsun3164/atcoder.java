package abc.abc201_250.abc225;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data()).toArray(Data[]::new);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int t = scanner.nextInt();
				if (1 == t) {
					int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
					datas[x].next = y;
					datas[y].prev = x;
				} else if (2 == t) {
					int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
					datas[x].next = datas[y].prev = null;
				} else {
					int x = scanner.nextInt() - 1;
					List<Integer> list = print(datas, x);
					sb.append(list.size()).append(" ")
							.append(list.stream().map(i -> i.toString()).collect(Collectors.joining(" ")))
							.append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 電車xが含まれる連結成分に属する電車の番号を、先頭から順番に全てlistに出力する
	 *
	 * @param datas 電車の一覧
	 * @param x     電車x
	 * @return 電車xが含まれる連結成分に属する電車の番号を、先頭から順番を含むlist
	 */
	private static List<Integer> print(Data[] datas, int x) {
		List<Integer> list = new ArrayList<>();
		int now = x;
		while (datas[now].prev != null) {
			now = datas[now].prev;
		}
		list.add(now + 1);
		while (datas[now].next != null) {
			now = datas[now].next;
			list.add(now + 1);
		}
		return list;
	}

	/**
	 * prev,nextを含むクラス
	 */
	private static class Data {
		Integer prev, next;

		Data() {
			prev = next = null;
		}
	}
}
