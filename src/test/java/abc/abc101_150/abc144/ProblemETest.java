package abc.abc101_150.abc144;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 5\n" + "4 2 1\n" + "2 3 1", "2");
	}

	@Test
	void case2() {
		check("3 8\n" + "4 2 1\n" + "2 3 1", "0");
	}

	@Test
	void case3() {
		check("11 14\n" + "3 1 4 1 5 9 2 6 5 3 5\n" + "8 9 7 9 3 2 3 8 4 6 2", "12");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC144/E");
	}
}
