package abc.abc051_100.abc053;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 2 1 3 7", "3");
	}

	@Test
	void case2() {
		check("15\n" + "1 3 5 2 1 3 2 8 8 6 2 6 11 1 1", "7");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC068/D");
	}
}
