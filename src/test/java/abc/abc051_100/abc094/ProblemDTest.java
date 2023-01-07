package abc.abc051_100.abc094;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check(5, new int[] { 6, 9, 4, 2, 11 }, 11, 6);
	}

	private void check(int n, int[] a, int expectedAi, int expectedAj) {
		in.input(n);
		in.input(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		String[] numbers = lines[0].split("\\s+");
		assertEquals(2, numbers.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int ai = scanner.nextInt(), aj = scanner.nextInt();
			assertEquals(expectedAi, ai);
			assertTrue((expectedAj == aj) || ((expectedAj == (ai - aj)) && set.contains(ai - aj)),
					"expected " + expectedAj + " and actual is " + aj);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@Test
	void case2() {
		check(2, new int[] { 100, 0 }, 100, 0);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC095/D", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
			int n = inputScanner.nextInt();
			check(n, IntStream.range(0, n).map(i -> inputScanner.nextInt()).toArray(), expectedScanner.nextInt(),
					expectedScanner.nextInt());
		}
	}
}
