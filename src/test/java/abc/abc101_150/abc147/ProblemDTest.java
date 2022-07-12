package abc.abc101_150.abc147;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 3", "6");
	}

	@Test
	void case2() {
		check("10\n" + "3 1 4 1 5 9 2 6 5 3", "237");
	}

	@Test
	void case3() {
		check("10\n" + "3 14 159 2653 58979 323846 2643383 27950288 419716939 9375105820", "103715602");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC147/D");
	}
}
