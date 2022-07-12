package abc.abc101_150.abc107;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "-30 -10 10 20 50", "40");
	}

	@Test
	void case2() {
		check("3 2\n" + "10 20 30", "20");
	}

	@Test
	void case3() {
		check("1 1\n" + "0", "0");
	}

	@Test
	void case4() {
		check("8 5\n" + "-9 -7 -4 -3 1 2 3 4", "10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC107/C");
	}
}
