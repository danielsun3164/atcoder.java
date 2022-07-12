package abc.abc151_200.abc185;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 2\n" + "1 3", "3");
	}

	@Test
	void case2() {
		check("13 3\n" + "13 3 9", "6");
	}

	@Test
	void case3() {
		check("5 5\n" + "5 2 1 4 3", "0");
	}

	@Test
	void case4() {
		check("1 0\n", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC185/D");
	}
}
