package abc.abc201_250.abc212;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "1 6\n" + "4 9", "2");
	}

	@Test
	void case2() {
		check("1 1\n" + "10\n" + "10", "0");
	}

	@Test
	void case3() {
		check("6 8\n" + "82 76 82 82 71 70\n" + "17 39 67 2 45 35 22 24", "3");
	}
}
