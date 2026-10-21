package abc.abc201_250.abc246;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答Test extends TestBase {

	@Test
	void case1() {
		check("7\n" + "2 4 6 5 6 10\n" + "1 2\n" + "1 3\n" + "2 4\n" + "2 5\n" + "5 6\n" + "5 7", "5");
	}

	@Test
	void case2() {
		check("30\n" + "29 27 79 27 30 4 93 89 44 88 70 75 96 3 78 39 97 12 53 62 32 38 84 49 93 53 26 13 25\n"
				+ "13 15\n" + "14 22\n" + "17 24\n" + "12 3\n" + "4 3\n" + "5 8\n" + "26 15\n" + "3 2\n" + "2 9\n"
				+ "4 25\n" + "4 13\n" + "2 10\n" + "28 15\n" + "6 4\n" + "2 5\n" + "19 9\n" + "2 7\n" + "2 14\n"
				+ "23 30\n" + "17 2\n" + "7 16\n" + "21 13\n" + "13 23\n" + "13 20\n" + "1 2\n" + "6 18\n" + "27 6\n"
				+ "21 29\n" + "11 8", "70");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc246/G");
	}
}
