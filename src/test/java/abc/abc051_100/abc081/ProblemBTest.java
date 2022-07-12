package abc.abc051_100.abc081;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "8 12 40", "2");
	}

	@Test
	void case2() {
		check("4\n" + "5 6 8 10", "0");
	}

	@Test
	void case3() {
		check("6\n" + "382253568 723152896 37802240 379425024 404894720 471526144", "8");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC086/B");
	}
}
