package abc.abc041;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "140 180 160", "2" + LF + "3" + LF + "1");
	}

	@Test
	void case2() {
		check("2\n" + "1000000000 1", "1" + LF + "2");
	}

	@Test
	void case3() {
		check("8\n" + "3 1 4 15 9 2 6 5",
				"4" + LF + "5" + LF + "7" + LF + "8" + LF + "3" + LF + "1" + LF + "6" + LF + "2");
	}
}
