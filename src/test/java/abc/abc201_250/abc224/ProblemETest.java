package abc.abc201_250.abc224;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 3 7\n" + "1 1 4\n" + "1 2 7\n" + "2 1 3\n" + "2 3 5\n" + "3 1 2\n" + "3 2 5\n" + "3 3 5",
				"1" + LF + "0" + LF + "2" + LF + "0" + LF + "3" + LF + "1" + LF + "0");
	}

	@Test
	void case2() {
		check("5 7 20\n" + "2 7 8\n" + "2 6 4\n" + "4 1 9\n" + "1 5 4\n" + "2 2 7\n" + "5 5 2\n" + "1 7 2\n" + "4 6 6\n"
				+ "1 4 1\n" + "2 1 10\n" + "5 6 9\n" + "5 3 3\n" + "3 7 9\n" + "3 6 3\n" + "4 3 4\n" + "3 3 10\n"
				+ "4 2 1\n" + "3 5 4\n" + "1 2 6\n" + "4 7 9",
				"2" + LF + "4" + LF + "1" + LF + "5" + LF + "3" + LF + "6" + LF + "6" + LF + "2" + LF + "7" + LF + "0"
						+ LF + "0" + LF + "4" + LF + "1" + LF + "5" + LF + "3" + LF + "0" + LF + "5" + LF + "2" + LF
						+ "4" + LF + "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc224/E");
	}
}
