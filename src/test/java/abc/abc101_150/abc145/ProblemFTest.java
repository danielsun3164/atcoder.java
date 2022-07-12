package abc.abc101_150.abc145;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 1\n" + "2 3 4 1", "3");
	}

	@Test
	void case2() {
		check("6 2\n" + "8 6 9 1 2 1", "7");
	}

	@Test
	void case3() {
		check("10 0\n" + "1 1000000000 1 1000000000 1 1000000000 1 1000000000 1 1000000000", "4999999996");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC145/F");
	}
}
