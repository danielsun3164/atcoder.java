package abc.abc201_250.abc205;

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
		check("45 200", 90.0d);
	}

	@Test
	void case2() {
		check("37 450", 166.5d);
	}

	@Test
	void case3() {
		check("0 1000", 0.0d);
	}

	@Test
	void case4() {
		check("50 0", 0.0d);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc205/A", TOLERANCE);
	}
}
