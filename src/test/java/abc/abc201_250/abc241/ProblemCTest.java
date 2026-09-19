package abc.abc201_250.abc241;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("8\n" + "........\n" + "........\n" + ".#.##.#.\n" + "........\n" + "........\n" + "........\n"
				+ "........\n" + "........", "Yes");
	}

	@Test
	void case2() {
		check("6\n" + "######\n" + "######\n" + "######\n" + "######\n" + "######\n" + "######", "Yes");
	}

	@Test
	void case3() {
		check("10\n" + "..........\n" + "#..##.....\n" + "..........\n" + "..........\n" + "....#.....\n"
				+ "....#.....\n" + ".#...#..#.\n" + "..........\n" + "..........\n" + "..........", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc241/C");
	}
}
