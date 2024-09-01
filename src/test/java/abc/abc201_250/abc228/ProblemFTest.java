package abc.abc201_250.abc228;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 4 2 3 3 1\n" + "3 1 4 1\n" + "5 9 2 6\n" + "5 3 5 8", "19");
	}

	@Test
	void case2() {
		check("3 4 2 3 3 4\n" + "3 1 4 1\n" + "5 9 2 6\n" + "5 3 5 8", "0");
	}

	@Test
	void case3() {
		check("10 10 3 7 2 3\n" + "9 7 19 7 10 4 13 9 4 8\n" + "10 15 16 3 18 19 17 12 13 2\n"
				+ "12 18 4 9 13 13 6 13 5 2\n" + "16 12 2 14 18 17 14 7 8 12\n" + "12 13 17 12 14 15 19 7 13 15\n"
				+ "5 2 16 10 4 6 1 2 7 8\n" + "10 14 14 10 9 13 11 4 9 19\n" + "16 12 3 19 19 6 2 19 14 20\n"
				+ "15 3 19 19 2 10 1 4 3 15\n" + "13 20 5 6 19 1 7 17 10 19", "180");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc228/F");
	}
}
