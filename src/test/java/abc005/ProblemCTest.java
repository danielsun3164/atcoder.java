package abc005;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "3\n" + "1 2 3\n" + "3\n" + "2 3 4", "yes");
	}

	@Test
	void case2() {
		check("1\n" + "3\n" + "1 2 3\n" + "3\n" + "2 3 5", "no");
	}

	@Test
	void case3() {
		check("1\n" + "3\n" + "1 2 3\n" + "10\n" + "1 2 3 4 5 6 7 8 9 10", "no");
	}

	@Test
	void case4() {
		check("1\n" + "3\n" + "1 2 3\n" + "3\n" + "1 2 2", "no");
	}

	@Test
	void case5() {
		check("2\n" + "5\n" + "1 3 6 10 15\n" + "3\n" + "4 8 16", "yes");
	}
}
