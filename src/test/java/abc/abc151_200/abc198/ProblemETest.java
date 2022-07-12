package abc.abc151_200.abc198;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "2 7 1 8 2 8\n" + "1 2\n" + "3 6\n" + "3 2\n" + "4 3\n" + "2 5",
				"1" + LF + "2" + LF + "3" + LF + "4" + LF + "6");
	}

	@Test
	void case2() {
		check("10\n" + "3 1 4 1 5 9 2 6 5 3\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "5 6\n" + "6 7\n" + "7 8\n"
				+ "8 9\n" + "9 10", "1" + LF + "2" + LF + "3" + LF + "5" + LF + "6" + LF + "7" + LF + "8");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc198/E");
	}
}
