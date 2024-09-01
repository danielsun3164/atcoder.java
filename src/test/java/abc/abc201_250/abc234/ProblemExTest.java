package abc.abc201_250.abc234;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("6 5\n" + "2 0\n" + "2 2\n" + "3 4\n" + "0 0\n" + "5 5\n" + "8 3", "9" + LF + "1 2" + LF + "1 3" + LF
				+ "1 4" + LF + "2 3" + LF + "2 4" + LF + "2 5" + LF + "3 4" + LF + "3 5" + LF + "5 6");
	}

	@Test
	void case2() {
		check("2 1414213562\n" + "0 0\n" + "1000000000 1000000000", "0");
	}

	@Test
	void case3() {
		check("10 150\n" + "300 300\n" + "300 400\n" + "300 500\n" + "400 300\n" + "400 400\n" + "400 400\n"
				+ "400 500\n" + "500 300\n" + "500 400\n" + "500 500",
				"29" + LF + "1 2" + LF + "1 4" + LF + "1 5" + LF + "1 6" + LF + "2 3" + LF + "2 4" + LF + "2 5" + LF
						+ "2 6" + LF + "2 7" + LF + "3 5" + LF + "3 6" + LF + "3 7" + LF + "4 5" + LF + "4 6" + LF
						+ "4 8" + LF + "4 9" + LF + "5 6" + LF + "5 7" + LF + "5 8" + LF + "5 9" + LF + "5 10" + LF
						+ "6 7" + LF + "6 8" + LF + "6 9" + LF + "6 10" + LF + "7 9" + LF + "7 10" + LF + "8 9" + LF
						+ "9 10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc234/Ex");
	}
}
