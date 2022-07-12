package abc.abc101_150.abc133;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 2\n" + "5 5\n" + "-2 8", "1");
	}

	@Test
	void case2() {
		check("3 4\n" + "-3 7 8 2\n" + "-12 1 10 2\n" + "-2 8 9 3", "2");
	}

	@Test
	void case3() {
		check("5 1\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5", "10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC133/B");
	}
}
