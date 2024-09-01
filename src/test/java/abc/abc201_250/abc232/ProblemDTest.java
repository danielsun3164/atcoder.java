package abc.abc201_250.abc232;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + ".#..\n" + "..#.\n" + "..##", "4");
	}

	@Test
	void case2() {
		check("1 1\n" + ".", "1");
	}

	@Test
	void case3() {
		check("5 5\n" + ".....\n" + ".....\n" + ".....\n" + ".....\n" + ".....", "9");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc232/D");
	}
}
