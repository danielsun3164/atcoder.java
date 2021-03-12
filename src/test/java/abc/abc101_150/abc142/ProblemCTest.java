package abc.abc101_150.abc142;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 3 1", "3 1 2");
	}

	@Test
	void case2() {
		check("5\n" + "1 2 3 4 5", "1 2 3 4 5");
	}

	@Test
	void case3() {
		check("8\n" + "8 2 7 3 4 5 6 1", "8 2 4 5 6 7 3 1");
	}
}
