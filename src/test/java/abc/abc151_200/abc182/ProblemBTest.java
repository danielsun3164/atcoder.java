package abc.abc151_200.abc182;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 12 7", "3");
	}

	@Test
	void case2() {
		checkResultIn("5\n" + "8 9 18 90 72", "2", "3", "9");
	}

	@Test
	void case3() {
		checkResultIn("5\n" + "1000 1000 1000 1000 1000", "2", "4", "5", "10", "20", "40", "50", "100", "200", "500",
				"1000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC182/B");
	}
}
