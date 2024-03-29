package abc.abc151_200.abc193;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-2d;

	@Test
	void case1() {
		checkResultIsAbout("100 80", 20.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("7 6", 14.285714285714285714d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("99999 99998", 0.00100001000010000100d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC193/A", TOLERANCE);
	}
}
