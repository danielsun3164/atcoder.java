package abc.abc201_250.abc206;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 7 1", "2");
	}

	@Test
	void case2() {
		check("10\n" + "1 10 100 1000 10000 100000 1000000 10000000 100000000 1000000000", "45");
	}

	@Test
	void case3() {
		check("20\n" + "7 8 1 1 4 9 9 6 8 2 4 1 1 9 5 5 5 3 6 4", "173");
	}
}
