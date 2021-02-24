package abc.abc101_150.abc136;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemD {
	/** 右を表す文字 */
	private static final char RIGHT = 'R';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray();
			int[] answers = new int[s.length];
			Arrays.fill(answers, 0);
			int start = 0, lastR = 0;
			boolean hasL = false;
			for (int i = 0; i < s.length; i++) {
				if (RIGHT == s[i]) {
					if (hasL) {
						calc(answers, start, i, lastR);
						start = i;
						hasL = false;
					}
					lastR = i;
				} else {
					hasL = true;
				}
			}
			calc(answers, start, s.length, lastR);
			System.out.println(Arrays.stream(answers).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	/**
	 * RRLLの区間の結果を計算する
	 * 
	 * @param answers 結果を格納する配列
	 * @param start   区間の開始地点
	 * @param end     区間の終了地点+1
	 * @param lastR   最後にRが現れた場所
	 */
	private static void calc(int[] answers, int start, int end, int lastR) {
		int count = end - start;
		if (0 == (1 & count)) {
			answers[lastR] = count >> 1;
			answers[lastR + 1] = count >> 1;
		} else {
			answers[lastR] = (count >> 1) + (1 - ((lastR - start) & 1));
			answers[lastR + 1] = (count >> 1) + ((lastR - start) & 1);
		}
	}
}
