package abc079;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ProblemC {

	private static final Integer SEVEN = 7;

	public static void main(String[] args) throws ScriptException {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] abcd = scanner.next().toCharArray();
			for (int i = 0; i < pow(2, abcd.length) - 1; i++) {
				if (ok(abcd, i)) {
					System.out.println(toFormula(abcd, i) + "=" + SEVEN);
					return;
				}
			}
		}
	}

	/**
	 * nのmべき乗を返す
	 * 
	 * @param n
	 * @param m
	 * @return nのmべき乗
	 */
	private static int pow(int n, int m) {
		int result = 1;
		while (m > 0) {
			if (1 == (m & 1)) {
				result *= n;
			}
			n *= n;
			m >>= 1;
		}
		return result;
	}

	/**
	 * abcdと'+'か'-'を表す二進数で数式を組み立てて、結果が7かどうかを判定
	 * 
	 * @param abcd
	 * @param n    '+'か'-'を表す二進数
	 * @return 結果が7かどうか
	 */
	private static boolean ok(char[] abcd, int n) throws ScriptException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
		return SEVEN.equals(engine.eval(toFormula(abcd, n)));
	}

	/**
	 * abcdと'+'か'-'を表す二進数で数式を組み立てる
	 * 
	 * @param abcd
	 * @param n    '+'か'-'を表す二進数
	 * @return a?b?c?d の数式
	 */
	private static String toFormula(char[] abcd, int n) {
		StringBuilder result = new StringBuilder();
		for (char c : abcd) {
			result.append(c);
			result.append((1 == (n & 1)) ? '+' : '-');
			n >>= 1;
		}
		// 最後の文字を削除
		result.deleteCharAt(result.length() - 1);
		return result.toString();
	}
}
