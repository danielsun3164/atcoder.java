package abc088;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 0 1\n" + "2 1 2\n" + "1 0 1", "Yes");
	}

	@Test
	void case2() {
		check("2 2 2\n" + "2 1 2\n" + "2 2 2", "No");
	}

	@Test
	void case3() {
		check("0 8 8\n" + "0 8 8\n" + "0 8 8", "Yes");
	}

	@Test
	void case4() {
		check("1 8 6\n" + "2 9 7\n" + "0 7 7", "No");
	}
}
