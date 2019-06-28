package abc029;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProblemC {

	/** パスワードに使用されるアルファベット */
	private static final List<String> ALPHABETA_LIST = Arrays.asList("a", "b", "c");

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			List<String> list = getPasswords(n);
			list.forEach(System.out::println);
		}
	}

	/**
	 * @param n
	 * @return n桁のパスワードの一覧を取得する
	 */
	private static List<String> getPasswords(int n) {
		if (1 == n) {
			return ALPHABETA_LIST;
		}
		List<String> resultList = new ArrayList<>();
		List<String> subList = getPasswords(n - 1);
		ALPHABETA_LIST.forEach(s -> subList.forEach(t -> resultList.add(s + t)));
		return resultList;
	}
}
