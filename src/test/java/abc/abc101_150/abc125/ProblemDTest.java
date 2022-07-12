package abc.abc101_150.abc125;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "-10 5 -4", "19");
	}

	@Test
	void case2() {
		check("5\n" + "10 -4 -8 -11 3", "30");
	}

	@Test
	void case3() {
		check("11\n"
				+ "-1000000000 1000000000 -1000000000 1000000000 -1000000000 0 1000000000 -1000000000 1000000000 -1000000000 1000000000",
				"10000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC125/D");
	}
}
