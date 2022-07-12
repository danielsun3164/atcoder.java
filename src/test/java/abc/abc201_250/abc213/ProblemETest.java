package abc.abc201_250.abc213;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "..#..\n" + "#.#.#\n" + "##.##\n" + "#.#.#\n" + "..#..", "1");
	}

	@Test
	void case2() {
		check("5 7\n" + ".......\n" + "######.\n" + ".......\n" + ".######\n" + ".......", "0");
	}

	@Test
	void case3() {
		check("8 8\n" + ".#######\n" + "########\n" + "########\n" + "########\n" + "########\n" + "########\n"
				+ "########\n" + "#######.", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc213/E");
	}
}
