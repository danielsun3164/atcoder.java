package abc.abc051_100.abc072;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 4 3 5 2", "2");
	}

	@Test
	void case2() {
		check("2\n" + "1 2", "1");
	}

	@Test
	void case3() {
		check("2\n" + "2 1", "0");
	}

	@Test
	void case4() {
		check("9\n" + "1 2 4 9 5 8 7 3 6", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC082/D");
	}
}
