package abc.abc201_250.abc238;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("16", "73");
	}

	@Test
	void case2() {
		check("238", "13870");
	}

	@Test
	void case3() {
		check("999999999999999999", "762062362");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc238/C");
	}
}
