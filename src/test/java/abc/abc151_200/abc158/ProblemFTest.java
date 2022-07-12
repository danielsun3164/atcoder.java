package abc.abc151_200.abc158;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 5\n" + "3 3", "3");
	}

	@Test
	void case2() {
		check("3\n" + "6 5\n" + "-1 10\n" + "3 3", "5");
	}

	@Test
	void case3() {
		check("4\n" + "7 10\n" + "-10 3\n" + "4 3\n" + "-4 3", "16");
	}

	@Test
	void case4() {
		check("20\n" + "-8 1\n" + "26 4\n" + "0 5\n" + "9 1\n" + "19 4\n" + "22 20\n" + "28 27\n" + "11 8\n" + "-3 20\n"
				+ "-25 17\n" + "10 4\n" + "-18 27\n" + "24 28\n" + "-11 19\n" + "2 27\n" + "-2 18\n" + "-1 12\n"
				+ "-24 29\n" + "31 29\n" + "29 7", "110");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC158/F");
	}
}
