package abc.abc102;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "2 2 3 5 5", "2");
	}

	@Test
	void case2() {
		check("9\n" + "1 2 3 4 5 6 7 8 9", "0");
	}

	@Test
	void case3() {
		check("6\n" + "6 5 4 3 2 1", "18");
	}

	@Test
	void case4() {
		check("7\n" + "1 1 1 1 2 3 4", "6");
	}
}
