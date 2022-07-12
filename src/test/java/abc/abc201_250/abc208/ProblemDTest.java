package abc.abc201_250.abc208;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 2 3\n" + "2 3 2", "25");
	}

	@Test
	void case2() {
		check("3 0", "0");
	}

	@Test
	void case3() {
		check("5 20\n" + "1 2 6\n" + "1 3 10\n" + "1 4 4\n" + "1 5 1\n" + "2 1 5\n" + "2 3 9\n" + "2 4 8\n" + "2 5 6\n"
				+ "3 1 5\n" + "3 2 1\n" + "3 4 7\n" + "3 5 9\n" + "4 1 4\n" + "4 2 6\n" + "4 3 4\n" + "4 5 8\n"
				+ "5 1 2\n" + "5 2 5\n" + "5 3 6\n" + "5 4 5", "517");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc208/D");
	}
}
