package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX15Test extends TestBase {

	@Test
	void case1() {
		check("2\n" + "5 7\n" + "4 10\n" + "9 2", "1848");
	}

	@Test
	void case2() {
		check("3\n" + "100 100 100\n" + "100 100 100\n" + "100 100 100", "27000000");
	}

	@Test
	void case3() {
		check("5\n" + "95 20 74 81 10\n" + "100 50 32 84 31\n" + "0 0 0 0 0", "0");
	}

	@Test
	void case4() {
		check("2\n" + "10 0\n" + "0 5\n" + "1 1", "100");
	}
}
