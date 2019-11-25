package abc031;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() throws IOException {
		int k = 6;
		Map<String, String> inputMap = new HashMap<>();
		inputMap.put("356", "migoro");
		inputMap.put("461", "yoroi");
		inputMap.put("2", "ni");
		inputMap.put("12", "ini");
		in.input(k + " " + inputMap.size());
		inputMap.entrySet().forEach(entry -> in.input(entry.getKey() + " " + entry.getValue()));
		ProblemD.main(null);
		Map<String, String> outputMap = new HashMap<>();
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			IntStream.rangeClosed(1, k).forEach(i -> outputMap.put(String.valueOf(i), scanner.nextLine()));
		}
		inputMap.entrySet().forEach(entry -> {
			StringBuilder sb = new StringBuilder();
			String key = entry.getKey();
			IntStream.range(0, key.length()).forEach(i -> sb.append(outputMap.get(key.substring(i, i + 1))));
			assertEquals(entry.getValue(), sb.toString());
		});
	}

	@Test
	void case2() throws IOException {
		int k = 3;
		Map<String, String> inputMap = new HashMap<>();
		inputMap.put("12", "aaa");
		inputMap.put("21", "aaa");
		inputMap.put("123", "aaaaaa");
		inputMap.put("13", "aaaa");
		in.input(k + " " + inputMap.size());
		inputMap.entrySet().forEach(entry -> in.input(entry.getKey() + " " + entry.getValue()));
		ProblemD.main(null);
		Map<String, String> outputMap = new HashMap<>();
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			IntStream.rangeClosed(1, k).forEach(i -> outputMap.put(String.valueOf(i), scanner.nextLine()));
		}
		inputMap.entrySet().forEach(entry -> {
			StringBuilder sb = new StringBuilder();
			String key = entry.getKey();
			IntStream.range(0, key.length()).forEach(i -> sb.append(outputMap.get(key.substring(i, i + 1))));
			assertEquals(entry.getValue(), sb.toString());
		});
	}

	@Test
	void case3() throws IOException {
		int k = 2;
		Map<String, String> inputMap = new HashMap<>();
		inputMap.put("12211", "abcaaaaabcabc");
		inputMap.put("2121", "aaabcaaabc");
		inputMap.put("222221", "aaaaaaaaaaabc");
		in.input(k + " " + inputMap.size());
		inputMap.entrySet().forEach(entry -> in.input(entry.getKey() + " " + entry.getValue()));
		ProblemD.main(null);
		Map<String, String> outputMap = new HashMap<>();
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			IntStream.rangeClosed(1, k).forEach(i -> outputMap.put(String.valueOf(i), scanner.nextLine()));
		}
		inputMap.entrySet().forEach(entry -> {
			StringBuilder sb = new StringBuilder();
			String key = entry.getKey();
			IntStream.range(0, key.length()).forEach(i -> sb.append(outputMap.get(key.substring(i, i + 1))));
			assertEquals(entry.getValue(), sb.toString());
		});
	}

	@Test
	void case4() throws IOException {
		int k = 2;
		Map<String, String> inputMap = new HashMap<>();
		inputMap.put("12", "abcab");
		in.input(k + " " + inputMap.size());
		inputMap.entrySet().forEach(entry -> in.input(entry.getKey() + " " + entry.getValue()));
		ProblemD.main(null);
		Map<String, String> outputMap = new HashMap<>();
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			IntStream.rangeClosed(1, k).forEach(i -> outputMap.put(String.valueOf(i), scanner.nextLine()));
		}
		inputMap.entrySet().forEach(entry -> {
			StringBuilder sb = new StringBuilder();
			String key = entry.getKey();
			IntStream.range(0, key.length()).forEach(i -> sb.append(outputMap.get(key.substring(i, i + 1))));
			assertEquals(entry.getValue(), sb.toString());
		});
	}
}
