package abc.abc201_250.abc242;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("30 500 20 103", 0.042553191489d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("50 500 100 1", 1.0d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("1 2 1 1000", 0.0d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc242/A", TOLERANCE);
	}
}
