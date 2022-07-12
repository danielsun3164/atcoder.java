package other.zone2021;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 9 6 4 6\n" + "6 9 3 1 1\n" + "8 8 9 3 7", "4");
	}

	@Test
	void case2() {
		check("5\n" + "6 13 6 19 11\n" + "4 4 12 11 18\n" + "20 7 19 2 5\n" + "15 5 12 20 7\n" + "8 7 6 18 5", "13");
	}

	@Test
	void case3() {
		check("10\n" + "6 7 5 18 2\n" + "3 8 1 6 3\n" + "7 2 8 7 7\n" + "6 3 3 4 7\n" + "12 8 9 15 9\n" + "9 8 6 1 10\n"
				+ "12 9 7 8 2\n" + "10 3 17 4 10\n" + "3 1 3 19 3\n" + "3 14 7 13 1", "10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ZONe2021/C");
	}
}
