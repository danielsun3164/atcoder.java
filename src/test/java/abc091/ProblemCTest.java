package abc091;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 0\n" + "3 1\n" + "1 3\n" + "4 2\n" + "0 4\n" + "5 5", "2");
	}

	@Test
	void case2() {
		check("3\n" + "0 0\n" + "1 1\n" + "5 2\n" + "2 3\n" + "3 4\n" + "4 5", "2");
	}

	@Test
	void case3() {
		check("2\n" + "2 2\n" + "3 3\n" + "0 0\n" + "1 1", "0");
	}

	@Test
	void case4() {
		check("5\n" + "0 0\n" + "7 3\n" + "2 2\n" + "4 8\n" + "1 6\n" + "8 5\n" + "6 9\n" + "5 4\n" + "9 1\n" + "3 7",
				"5");
	}

	@Test
	void case5() {
		check("5\n" + "0 0\n" + "1 1\n" + "5 5\n" + "6 6\n" + "7 7\n" + "2 2\n" + "3 3\n" + "4 4\n" + "8 8\n" + "9 9",
				"4");
	}
}
