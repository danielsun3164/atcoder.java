package abc.abc201_250.abc224;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	private static final double TOLERANCE = 1E-5;

	@Test
	void case1() {
		checkResultIsAbout("5 2 4 10 4", 15.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("10 6 6 1 2", 0.0d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("1000000000 1000000000 1 1000000000 1000000000", 1000000000000000000.0d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc224/G", TOLERANCE);
	}
}
