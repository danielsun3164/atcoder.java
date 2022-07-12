package abc.abc051_100.abc074;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "0 1 3\n" + "1 0 2\n" + "3 2 0", "3");
	}

	@Test
	void case2() {
		check("3\n" + "0 1 3\n" + "1 0 1\n" + "3 1 0", "-1");
	}

	@Test
	void case3() {
		check("5\n" + "0 21 18 11 28\n" + "21 0 13 10 26\n" + "18 13 0 23 13\n" + "11 10 23 0 17\n" + "28 26 13 17 0",
				"82");
	}

	@Test
	void case4() {
		check("3\n" + "0 1000000000 1000000000\n" + "1000000000 0 1000000000\n" + "1000000000 1000000000 0",
				"3000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC083/D");
	}
}
