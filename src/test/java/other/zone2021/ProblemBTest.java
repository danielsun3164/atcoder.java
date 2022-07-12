package other.zone2021;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-3d;

	@Test
	void case1() {
		checkResultIsAbout("1 10 10\n" + "3 5", 2.857142857142857d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("1 10 10\n" + "3 2", 0.0d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("5 896 483\n" + "228 59\n" + "529 310\n" + "339 60\n" + "78 266\n" + "659 391",
				245.3080684596577d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ZONe2021/B", TOLERANCE);
	}
}
