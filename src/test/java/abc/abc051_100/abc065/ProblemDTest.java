package abc.abc051_100.abc065;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 5\n" + "3 9\n" + "7 8", "3");
	}

	@Test
	void case2() {
		check("6\n" + "8 3\n" + "4 9\n" + "12 19\n" + "18 1\n" + "13 5\n" + "7 6", "8");
	}

	@Test
	void case3() {
		check("7\n" + "8 3\n" + "4 9\n" + "4 9\n" + "12 19\n" + "18 1\n" + "13 5\n" + "7 6", "8");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC076/D");
	}
}
