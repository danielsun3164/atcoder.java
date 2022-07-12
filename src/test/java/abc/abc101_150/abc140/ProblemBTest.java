package abc.abc101_150.abc140;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 1 2\n" + "2 5 4\n" + "3 6", "14");
	}

	@Test
	void case2() {
		check("4\n" + "2 3 4 1\n" + "13 5 8 24\n" + "45 9 15", "74");
	}

	@Test
	void case3() {
		check("2\n" + "1 2\n" + "50 50\n" + "50", "150");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC140/B");
	}
}
