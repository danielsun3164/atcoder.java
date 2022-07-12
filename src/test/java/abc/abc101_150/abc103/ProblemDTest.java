package abc.abc101_150.abc103;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 2\n" + "1 4\n" + "2 5", "1");

	}

	@Test
	void case2() {
		check("9 5\n" + "1 8\n" + "2 7\n" + "3 5\n" + "4 6\n" + "7 9", "2");
	}

	@Test
	void case3() {
		check("5 10\n" + "1 2\n" + "1 3\n" + "1 4\n" + "1 5\n" + "2 3\n" + "2 4\n" + "2 5\n" + "3 4\n" + "3 5\n"
				+ "4 5", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC103/D");
	}
}
