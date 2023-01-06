package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem044Test extends TestBase {

	@Test
	void case1() {
		check("8 5\n" + "6 17 2 4 17 19 1 7\n" + "2 0 0\n" + "1 7 2\n" + "1 2 6\n" + "1 4 5\n" + "3 4 0", "4");
	}

	@Test
	void case2() {
		check("9 6\n" + "16 7 10 2 9 18 15 20 5\n" + "2 0 0\n" + "1 1 4\n" + "2 0 0\n" + "1 8 5\n" + "2 0 0\n"
				+ "3 6 0", "18");
	}

	@Test
	void case3() {
		check("11 18\n" + "23 92 85 34 21 63 12 9 81 44 96\n" + "3 10 0\n" + "3 5 0\n" + "1 3 4\n" + "2 0 0\n"
				+ "1 4 11\n" + "3 11 0\n" + "1 3 5\n" + "2 0 0\n" + "2 0 0\n" + "3 9 0\n" + "2 0 0\n" + "3 6 0\n"
				+ "3 10 0\n" + "1 6 11\n" + "2 0 0\n" + "3 10 0\n" + "3 4 0\n" + "3 5 0",
				"44" + LF + "21" + LF + "34" + LF + "63" + LF + "85" + LF + "63" + LF + "21" + LF + "34" + LF + "96");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/044");
	}
}
