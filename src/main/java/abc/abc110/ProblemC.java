package abc.abc110;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc110/submissions/15896552 にも参考
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] s = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			Map<Character, Character> sMap = new HashMap<>(), tMap = new HashMap<>();
			boolean result = true;
			for (int i = 0; i < s.length; i++) {
				if (sMap.containsKey(s[i])) {
					if (sMap.get(s[i]) != t[i]) {
						result = false;
						break;
					}
				} else {
					sMap.put(s[i], t[i]);
				}
				if (tMap.containsKey(t[i])) {
					if (tMap.get(t[i]) != s[i]) {
						result = false;
						break;
					}
				} else {
					tMap.put(t[i], s[i]);
				}
			}
			System.out.println(result ? "Yes" : "No");
		}
	}
}
