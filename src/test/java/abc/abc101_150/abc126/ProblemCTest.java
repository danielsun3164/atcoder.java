package abc.abc101_150.abc126;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-9d;

	@Test
	void case1() {
		checkResultIsAbout("3 10", 0.145833333333d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("100000 5", 0.999973749998d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC126/C", TOLERANCE);
	}
}
