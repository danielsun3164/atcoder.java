package abc.abc201_250.abc231;

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
		checkResultIsAbout("1000", 10.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("50", 0.5d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("3141", 31.41d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc231/A");
	}
}
