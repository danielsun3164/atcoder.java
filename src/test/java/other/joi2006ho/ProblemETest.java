package other.joi2006ho;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("5 1    \n" + "0 0 3 2\n" + "1 1 2 5\n" + "0 4 6 5\n" + "3 3 5 6\n" + "5 0 7 6", "29");
	}

	@Test
	void case2() {
		check("5 2    \n" + "0 0 3 2\n" + "1 1 2 5\n" + "0 4 6 5\n" + "3 3 5 6\n" + "5 0 7 6", "29" + LF + "38");
	}

	@Test
	void case3() {
		check("2 2    \n" + "0 0 8 9\n" + "0 0 9 8", "80" + LF + "36");
	}

	@Test
	void case4() {
		check("3 2    \n" + "2 2 8 8\n" + "3 0 4 9\n" + "5 0 7 9", "45" + LF + "36");
	}
}
