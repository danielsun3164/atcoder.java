package abc.abc151_200.abc197;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "2 2\n" + "3 1\n" + "1 3\n" + "4 2\n" + "5 3", "12");
	}

	@Test
	void case2() {
		check("9\n" + "5 5\n" + "-4 4\n" + "4 3\n" + "6 3\n" + "-5 5\n" + "-3 2\n" + "2 2\n" + "3 3\n" + "1 4", "38");
	}
}
