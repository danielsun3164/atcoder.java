package abc.abc201_250.abc211;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5\n" + "#.#\n" + "...\n" + "..#", "5");
	}

	@Test
	void case2() {
		check("2\n" + "2\n" + "#.\n" + ".#", "0");
	}

	@Test
	void case3() {
		check("8\n" + "8\n" + "........\n" + "........\n" + "........\n" + "........\n" + "........\n" + "........\n"
				+ "........\n" + "........", "64678");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc211/E");
	}
}
