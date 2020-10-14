package abc.abc081;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 2\n" + "1 1 2 2 5", "1");
	}

	@Test
	void case2() {
		check("4 4\n" + "1 1 2 2", "0");
	}

	@Test
	void case3() {
		check("10 3\n" + "5 1 3 2 4 1 1 2 3 4", "3");
	}
}
