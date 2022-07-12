package abc.abc151_200.abc159;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		check("3", 1.0d);
	}

	@Test
	void case2() {
		check("999", 36926037.0d);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC159/C", TOLERANCE);
	}
}
