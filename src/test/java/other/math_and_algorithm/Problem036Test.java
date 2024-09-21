package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem036Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-9d;

	@Test
	void case1() {
		checkResultIsAbout("3 4 9 0", 5.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3 4 10 40", 4.56425719433005567605d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC168/C", TOLERANCE);
	}
}
