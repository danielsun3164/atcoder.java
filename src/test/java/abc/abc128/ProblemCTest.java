package abc.abc128;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "2 1 2\n" + "1 2\n" + "0 1", "1");
	}

	@Test
	void case2() {
		check("2 3\n" + "2 1 2\n" + "1 1\n" + "1 2\n" + "0 0 1", "0");
	}

	@Test
	void case3() {
		check("5 2\n" + "3 1 2 5\n" + "2 2 3\n" + "1 0", "8");
	}
}
