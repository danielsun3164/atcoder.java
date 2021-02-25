package abc.abc101_150.abc139;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "10 4 8 7 3", "2");
	}

	@Test
	void case2() {
		check("7\n" + "4 4 5 6 6 5 5", "3");
	}

	@Test
	void case3() {
		check("4\n" + "1 2 3 4", "0");
	}
}
