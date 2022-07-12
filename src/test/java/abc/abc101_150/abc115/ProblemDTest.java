package abc.abc101_150.abc115;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 7", "4");
	}

	@Test
	void case2() {
		check("1 1", "0");
	}

	@Test
	void case3() {
		check("50 4321098765432109", "2160549382716056");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC115/D");
	}
}
