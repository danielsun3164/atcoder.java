package abc.abc001_050.abc031;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		Map<String, String> inputMap = new HashMap<>();
		inputMap.put("356", "migoro");
		inputMap.put("461", "yoroi");
		inputMap.put("2", "ni");
		inputMap.put("12", "ini");
		check(6, inputMap);
	}

	@Test
	void case2() {
		Map<String, String> inputMap = new HashMap<>();
		inputMap.put("12", "aaa");
		inputMap.put("21", "aaa");
		inputMap.put("123", "aaaaaa");
		inputMap.put("13", "aaaa");
		check(3, inputMap);
	}

	@Test
	void case3() {
		Map<String, String> inputMap = new HashMap<>();
		inputMap.put("12211", "abcaaaaabcabc");
		inputMap.put("2121", "aaabcaaabc");
		inputMap.put("222221", "aaaaaaaaaaabc");
		check(2, inputMap);
	}

	@Test
	void case4() {
		Map<String, String> inputMap = new HashMap<>();
		inputMap.put("12", "abcab");
		check(2, inputMap);
	}

	private void check(int k, Map<String, String> inputMap) {
		in.input(k + " " + inputMap.size());
		inputMap.entrySet().forEach(entry -> in.input(entry.getKey() + " " + entry.getValue()));
		execute();
		String[] lines = out.toString().split("\\R");
		Map<String, String> outputMap = new HashMap<>();
		assertEquals(k, lines.length);
		IntStream.range(0, k).forEach(i -> outputMap.put(String.valueOf(i + 1), lines[i]));
		inputMap.entrySet().forEach(entry -> {
			StringBuilder sb = new StringBuilder();
			String key = entry.getKey();
			IntStream.range(0, key.length()).forEach(i -> sb.append(outputMap.get(key.substring(i, i + 1))));
			assertEquals(entry.getValue(), sb.toString());
		});
	}
}
