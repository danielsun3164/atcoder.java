package abc.abc151_200.abc182;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 -1 -2", "5");
	}

	@Test
	void case2() {
		check("5\n" + "-2 1 3 -1 -1", "2");
	}

	@Test
	void case3() {
		check("5\n" + "-1000 -1000 -1000 -1000 -1000", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC182/D");
	}
}
