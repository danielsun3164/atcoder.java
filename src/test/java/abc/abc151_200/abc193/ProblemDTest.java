package abc.abc151_200.abc193;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-5d;

	@Test
	void case1() {
		checkResultIsAbout("2\n" + "1144#\n" + "2233#", 0.4444444444444444d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("2\n" + "9988#\n" + "1122#", 1.0d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("6\n" + "1122#\n" + "2228#", 0.001932367149758454d, TOLERANCE);
	}

	@Test
	void case4() {
		checkResultIsAbout("100000\n" + "3226#\n" + "3597#", 0.6296297942426154d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC193/D", TOLERANCE);
	}
}
