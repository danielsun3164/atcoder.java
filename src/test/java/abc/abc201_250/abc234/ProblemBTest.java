package abc.abc201_250.abc234;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		checkResultIsAbout("3\n" + "0 0\n" + "0 1\n" + "1 1", 1.4142135624d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("5\n" + "315 271\n" + "-2 -621\n" + "-205 -511\n" + "-952 482\n" + "165 463",
				1455.7159750446d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc234/B", TOLERANCE);
	}
}
