package abc.abc201_250.abc222;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 5 0\n" + "2 3 2 1 4\n" + "1 2\n" + "2 3\n" + "3 4", "2");
	}

	@Test
	void case2() {
		check("3 10 10000\n" + "1 2 1 2 1 2 2 1 1 2\n" + "1 2\n" + "1 3", "0");
	}

	@Test
	void case3() {
		check("10 2 -1\n" + "1 10\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "5 6\n" + "6 7\n" + "7 8\n" + "8 9\n"
				+ "9 10", "126");
	}

	@Test
	void case4() {
		check("5 8 -1\n" + "1 4 1 4 2 1 3 5\n" + "1 2\n" + "4 1\n" + "3 1\n" + "1 5", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc222/E");
	}
}
