package abc.abc201_250.abc223;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	private static final double TOLERANCE = 1E-5d;

	@Test
	void case1() {
		checkResultIsAbout("3\n" + "1 1\n" + "2 1\n" + "3 1", 3.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3\n" + "1 3\n" + "2 2\n" + "3 1", 3.833333333333333d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("5\n" + "3 9\n" + "1 2\n" + "4 6\n" + "1 5\n" + "5 3", 8.916666666666668d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc223/C", TOLERANCE);
	}
}
