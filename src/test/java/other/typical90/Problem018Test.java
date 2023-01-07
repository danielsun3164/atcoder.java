package other.typical90;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem018Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-7d;

	@Test
	void case1() {
		check(4, 2, 1, 1, 4, new int[] { 0, 1, 2, 3 },
				new double[] { 0.000000000000d, 24.094842552111d, 54.735610317245d, 45.000000000000d });
	}

	@Test
	void case2() {
		check(5121, 312000000, 4123, 3314, 6, new int[] { 123, 12, 445, 4114, 42, 1233 },
				new double[] { 4.322765775902d, 0.421184234768d, 15.640867693969d, 35.396039162484d, 1.475665637902d,
						43.338582976959d });
	}

	void check(int t, int l, int x, int y, int q, int[] e, double[] expected) {
		in.input(t);
		in.input(l + " " + x + " " + y);
		in.input(q);
		for (int ei : e) {
			in.input(ei);
		}
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(q, lines.length);
		IntStream.range(0, q).forEach(i -> assertNumberIsAbout(expected[i], lines[i], TOLERANCE));
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/018", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
			int t = inputScanner.nextInt(), l = inputScanner.nextInt(), x = inputScanner.nextInt(),
					y = inputScanner.nextInt();
			int q = inputScanner.nextInt();
			int[] e = IntStream.range(0, q).map(i -> inputScanner.nextInt()).toArray();
			double[] expected = IntStream.range(0, q).mapToDouble(i -> expectedScanner.nextDouble()).toArray();
			check(t, l, x, y, q, e, expected);
		}
	}
}
