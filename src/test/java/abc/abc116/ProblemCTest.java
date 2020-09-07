package abc.abc116;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 2 2 1", "2");
	}

	@Test
	void case2() {
		check("5\n" + "3 1 2 3 1", "5");
	}

	@Test
	void case3() {
		check("8\n" + "4 23 75 0 23 96 50 100", "221");
	}
}
