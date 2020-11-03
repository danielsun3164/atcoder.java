package abc.abc048;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "2 2 2", "1");
	}

	@Test
	void case2() {
		check("6 1\n" + "1 6 1 2 0 4", "11");
	}

	@Test
	void case3() {
		check("5 9\n" + "3 1 4 1 5", "0");
	}

	@Test
	void case4() {
		check("2 0\n" + "5 5", "10");
	}
}
