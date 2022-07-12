package abc.abc151_200.abc170;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "24 11 8 3 16", "3");
	}

	@Test
	void case2() {
		check("4\n" + "5 5 5 5", "0");
	}

	@Test
	void case3() {
		check("10\n" + "33 18 45 28 8 19 89 86 2 4", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC170/D");
	}
}
