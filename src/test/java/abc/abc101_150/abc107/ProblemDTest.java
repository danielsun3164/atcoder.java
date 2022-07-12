package abc.abc101_150.abc107;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "10 30 20", "30");
	}

	@Test
	void case2() {
		check("1\n" + "10", "10");
	}

	@Test
	void case3() {
		check("10\n" + "5 9 5 9 8 9 3 5 4 3", "8");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC107/D");
	}
}
