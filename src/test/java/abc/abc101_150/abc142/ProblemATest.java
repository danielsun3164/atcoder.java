package abc.abc101_150.abc142;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		check("4", 0.5d);
	}

	@Test
	void case2() {
		checkResultIsAbout("5", 0.6d, TOLERANCE);
	}

	@Test
	void case3() {
		check("1", 1.0d);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC142/A", TOLERANCE);
	}
}
