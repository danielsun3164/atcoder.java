package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem083別回答Test extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "1 2\n" + "1 3\n" + "1 4\n" + "2 3\n" + "5\n" + "4 2\n" + "3 3\n" + "2 4\n" + "4 5\n" + "1 6",
				"1" + LF + "1" + LF + "3" + LF + "2" + LF + "5");
	}

	@Test
	void case2() {
		check("10 20\n" + "1 3\n" + "7 8\n" + "5 8\n" + "2 3\n" + "7 10\n" + "6 7\n" + "4 7\n" + "9 5\n" + "6 5\n"
				+ "2 9\n" + "4 2\n" + "5 7\n" + "3 10\n" + "4 8\n" + "1 8\n" + "10 8\n" + "5 3\n" + "9 1\n" + "7 3\n"
				+ "2 1\n" + "10\n" + "3 5\n" + "2 2\n" + "8 9\n" + "5 3\n" + "8 2\n" + "3 9\n" + "7 1\n" + "7 1\n"
				+ "8 4\n" + "6 8",
				"1" + LF + "5" + LF + "1" + LF + "9" + LF + "3" + LF + "3" + LF + "9" + LF + "1" + LF + "1" + LF + "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/083");
	}
}
