package abc.abc101;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "2 3 1 4", "2");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 2 3", "1");
	}

	@Test
	void case3() {
		check("8 3\n" + "7 3 1 8 4 6 2 5", "4");
	}
}
