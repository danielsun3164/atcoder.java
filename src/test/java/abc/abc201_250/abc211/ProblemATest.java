package abc.abc201_250.abc211;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-5d;

	@Test
	void case1() {
		checkResultIsAbout("130 100", 110.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("300 50", 133.3333333d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("123 123", 123.0d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc211/A", TOLERANCE);
	}
}
