package abc030;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "2 3\n" + "1 5 7\n" + "3 8 12 13", "2");
	}

	@Test
	void case2() {
		check("1 1\n" + "1 1\n" + "1\n" + "1", "0");
	}

	@Test
	void case3() {
		check("6 7\n" + "5 3\n" + "1 7 12 19 20 26\n" + "4 9 15 23 24 31 33", "3");
	}
}
