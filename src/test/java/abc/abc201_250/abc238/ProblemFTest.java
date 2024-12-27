package abc.abc201_250.abc238;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 2\n" + "2 4 3 1\n" + "2 1 4 3", "3");
	}

	@Test
	void case2() {
		check("33 16\n" + "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33\n"
				+ "33 32 31 30 29 28 27 26 25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1",
				"168558757");
	}

	@Test
	void case3() {
		check("15 7\n" + "4 9 7 5 6 13 2 11 3 1 12 14 15 10 8\n" + "4 14 9 12 7 15 1 2 8 11 3 5 13 6 10", "23");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc238/F");
	}
}
