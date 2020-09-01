package abc.abc166;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "2 3 3 1 3 1", "3");
	}

	@Test
	void case2() {
		check("6\n" + "5 2 4 2 8 8", "0");
	}

	@Test
	void case3() {
		check("32\n" + "3 1 4 1 5 9 2 6 5 3 5 8 9 7 9 3 2 3 8 4 6 2 6 4 3 3 8 3 2 7 9 5", "22");
	}
}
