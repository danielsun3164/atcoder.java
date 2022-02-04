package abc.abc101_150.abc138;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			Map<Character, NavigableSet<Integer>> map = new HashMap<>();
			IntStream.range(0, s.length).forEach(i -> {
				if (!map.containsKey(s[i])) {
					map.put(s[i], new TreeSet<>());
				}
				map.get(s[i]).add(i);
			});
			long answer = 0L;
			// sにおける現在のtの文字の位置
			int currentInS = s.length - 1;
			for (char c : t) {
				if (!map.containsKey(c)) {
					System.out.println(-1);
					return;
				}
				Integer index = map.get(c).higher(currentInS);
				if (null == index) {
					// 現在のsの位置以降にtの現在の文字がない場合
					answer += s.length - currentInS;
					currentInS = map.get(c).first();
					answer += currentInS;
				} else {
					// 現在のsの位置以降にtの現在の文字がある場合
					answer += index - currentInS;
					currentInS = index;
				}
			}
			System.out.println(answer);
		}
	}
}
