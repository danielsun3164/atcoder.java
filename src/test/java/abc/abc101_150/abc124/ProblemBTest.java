package abc.abc101_150.abc124;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "6 5 6 8", "3");
	}

	@Test
	void case2() {
		check("5\n" + "4 5 3 5 4", "3");
	}

	@Test
	void case3() {
		check("5\n" + "9 5 6 8 4", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC124/B");
	}
}
