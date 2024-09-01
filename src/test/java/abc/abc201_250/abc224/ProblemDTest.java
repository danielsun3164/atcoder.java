package abc.abc201_250.abc224;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 2\n" + "1 3\n" + "1 9\n" + "2 9\n" + "3 9\n" + "3 9 2 4 5 6 7 8", "5");
	}

	@Test
	void case2() {
		check("5\n" + "1 2\n" + "1 3\n" + "1 9\n" + "2 9\n" + "3 9\n" + "1 2 3 4 5 6 7 8", "0");
	}

	@Test
	void case3() {
		check("12\n" + "8 5\n" + "9 6\n" + "4 5\n" + "4 1\n" + "2 5\n" + "8 9\n" + "2 1\n" + "3 6\n" + "8 7\n" + "6 5\n"
				+ "7 4\n" + "2 3\n" + "1 2 3 4 5 6 8 7", "-1");
	}

	@Test
	void case4() {
		check("12\n" + "6 5\n" + "5 4\n" + "4 1\n" + "4 7\n" + "8 5\n" + "2 1\n" + "2 5\n" + "6 9\n" + "3 6\n" + "9 8\n"
				+ "8 7\n" + "3 2\n" + "2 3 4 6 1 9 7 8", "16");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc224/D");
	}
}
