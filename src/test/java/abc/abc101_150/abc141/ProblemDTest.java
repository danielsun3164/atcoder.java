package abc.abc101_150.abc141;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "2 13 8", "9");
	}

	@Test
	void case2() {
		check("4 4\n" + "1 9 3 5", "6");
	}

	@Test
	void case3() {
		check("1 100000\n" + "1000000000", "0");
	}

	@Test
	void case4() {
		check("10 1\n"
				+ "1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000",
				"9500000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC141/D");
	}
}
