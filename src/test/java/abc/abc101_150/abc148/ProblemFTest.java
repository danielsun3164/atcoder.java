package abc.abc101_150.abc148;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5 4 1\n" + "1 2\n" + "2 3\n" + "3 4\n" + "3 5", "2");
	}

	@Test
	void case2() {
		check("5 4 5\n" + "1 2\n" + "1 3\n" + "1 4\n" + "1 5", "1");
	}

	@Test
	void case3() {
		check("2 1 2\n" + "1 2", "0");
	}

	@Test
	void case4() {
		check("9 6 1\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "5 6\n" + "4 7\n" + "7 8\n" + "8 9", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC148/F");
	}
}
