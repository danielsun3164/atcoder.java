package abc071;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "3 1 2 4 2 1", "2");
	}

	@Test
	void case2() {
		check("4\n" + "1 2 3 4", "0");
	}

	@Test
	void case3() {
		check("10\n" + "3 3 3 3 4 4 4 5 5 5", "20");
	}
}
