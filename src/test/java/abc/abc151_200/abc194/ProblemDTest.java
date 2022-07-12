package abc.abc151_200.abc194;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		check("2", 2.0d);
	}

	@Test
	void case2() {
		check("3", 4.5d);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC194/D", TOLERANCE);
	}
}
