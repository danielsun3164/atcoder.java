package abc.abc201_250.abc244;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 0 -1 -1\n" + "0 1 2 0\n" + "-1 0 1 1\n" + "0 -1 1 -2", "-1" + LF + "2" + LF + "1" + LF + "2");
	}

	@Test
	void case2() {
		check("9\n" + "-1 4 -8 -2\n" + "9 -9 -7 7\n" + "4 1 6 7\n" + "-4 -1 -4 -5\n" + "-9 3 -2 -6\n" + "-1 0 -8 5\n"
				+ "-8 -5 0 0\n" + "8 3 0 -4\n" + "2 -5 2 5",
				"0" + LF + "35" + LF + "31" + LF + "21" + LF + "36" + LF + "87" + LF + "0" + LF + "36" + LF + "31");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc244/Ex");
	}
}
