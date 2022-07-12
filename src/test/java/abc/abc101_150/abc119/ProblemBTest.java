package abc.abc101_150.abc119;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-5d;

	@Test
	void case1() {
		checkResultIsAbout("2\n" + "10000 JPY\n" + "0.10000000 BTC", 48000.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3\n" + "100000000 JPY\n" + "100.00000000 BTC\n" + "0.00000001 BTC", 138000000.0038d,
				TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC119/B", TOLERANCE);
	}
}
