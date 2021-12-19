package abc.abc201_250.abc212;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 3\n" + "1 5\n" + "3\n" + "2 2\n" + "3", "3\n" + "7");
	}

	@Test
	void case2() {
		check("6\n" + "1 1000000000\n" + "2 1000000000\n" + "2 1000000000\n" + "2 1000000000\n" + "2 1000000000\n"
				+ "3", "5000000000");
	}
}
