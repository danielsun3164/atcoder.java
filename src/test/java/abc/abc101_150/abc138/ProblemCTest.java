package abc.abc101_150.abc138;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-5d;

	@Test
	void case1() {
		check("2\n" + "3 4", 3.5d);
	}

	@Test
	void case2() {
		check("3\n" + "500 300 200", 375.0d);
	}

	@Test
	void case3() {
		check("5\n" + "138 138 138 138 138", 138.0d);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC138/C", TOLERANCE);
	}
}
