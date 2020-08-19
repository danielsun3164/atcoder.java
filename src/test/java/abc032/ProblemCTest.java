package abc032;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("7 6\n" + "4\n" + "3\n" + "1\n" + "1\n" + "2\n" + "10\n" + "2", "4");
	}

	@Test
	void case2() {
		check("6 10\n" + "10\n" + "10\n" + "10\n" + "10\n" + "0\n" + "10", "6");
	}

	@Test
	void case3() {
		check("6 9\n" + "10\n" + "10\n" + "10\n" + "10\n" + "10\n" + "10", "0");
	}

	@Test
	void case4() {
		check("4 0\n" + "1\n" + "2\n" + "3\n" + "4", "0");
	}
}
