package abc.abc101_150.abc137;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 3 10\n" + "1 2 20\n" + "2 3 30\n" + "1 3 45", "35");
	}

	@Test
	void case2() {
		check("2 2 10\n" + "1 2 100\n" + "2 2 100", "-1");
	}

	@Test
	void case3() {
		check("4 5 10\n" + "1 2 1\n" + "1 4 1\n" + "3 4 1\n" + "2 2 100\n" + "3 3 100", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC137/E");
	}
}
