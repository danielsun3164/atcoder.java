package abc.abc101_150.abc117;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-3d;

	@Test
	void case1() {
		checkResultIsAbout("8 3", 2.6666666667d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("99 1", 99.0d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("1 100", 0.01d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC117/A", TOLERANCE);
	}
}
