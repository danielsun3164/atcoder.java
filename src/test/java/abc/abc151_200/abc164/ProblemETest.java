package abc.abc151_200.abc164;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 2 1\n" + "1 2 1 2\n" + "1 3 2 4\n" + "1 11\n" + "1 2\n" + "2 5", "2" + LF + "14");
	}

	@Test
	void case2() {
		check("4 4 1\n" + "1 2 1 5\n" + "1 3 4 4\n" + "2 4 2 2\n" + "3 4 1 1\n" + "3 1\n" + "3 1\n" + "5 2\n" + "6 4",
				"5" + LF + "5" + LF + "7");
	}

	@Test
	void case3() {
		check("6 5 1\n" + "1 2 1 1\n" + "1 3 2 1\n" + "2 4 5 1\n" + "3 5 11 1\n" + "1 6 50 1\n" + "1 10000\n"
				+ "1 3000\n" + "1 700\n" + "1 100\n" + "1 1\n" + "100 1",
				"1" + LF + "9003" + LF + "14606" + LF + "16510" + LF + "16576");
	}

	@Test
	void case4() {
		check("4 6 1000000000\n" + "1 2 50 1\n" + "1 3 50 5\n" + "1 4 50 7\n" + "2 3 50 2\n" + "2 4 50 4\n"
				+ "3 4 50 3\n" + "10 2\n" + "4 4\n" + "5 5\n" + "7 7", "1" + LF + "3" + LF + "5");
	}

	@Test
	void case5() {
		check("2 1 0\n" + "1 2 1 1\n" + "1 1000000000\n" + "1 1", "1000000001");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC164/E");
	}
}
