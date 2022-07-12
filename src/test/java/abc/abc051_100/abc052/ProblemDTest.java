package abc.abc051_100.abc052;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 2 5\n" + "1 2 5 7", "11");
	}

	@Test
	void case2() {
		check("7 1 100\n" + "40 43 45 105 108 115 124", "84");
	}

	@Test
	void case3() {
		check("7 1 2\n" + "24 35 40 68 72 99 103", "12");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC067/D");
	}
}
