package abc.abc094;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "2 4 4 3", "4" + LF + "3" + LF + "3" + LF + "4");
	}

	@Test
	void case2() {
		check("2\n" + "1 2", "2" + LF + "1");
	}

	@Test
	void case3() {
		check("6\n" + "5 5 4 4 3 3", "4" + LF + "4" + LF + "4" + LF + "4" + LF + "4" + LF + "4");
	}
}
