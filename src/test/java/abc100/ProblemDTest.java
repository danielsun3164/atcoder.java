package abc100;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "3 1 4\n" + "1 5 9\n" + "2 6 5\n" + "3 5 8\n" + "9 7 9", "56");
	}

	@Test
	void case2() {
		check("5 3\n" + "1 -2 3\n" + "-4 5 -6\n" + "7 -8 -9\n" + "-10 11 -12\n" + "13 -14 15", "54");
	}

	@Test
	void case3() {
		check("10 5\n" + "10 -80 21\n" + "23 8 38\n" + "-94 28 11\n" + "-26 -2 18\n" + "-69 72 79\n" + "-26 -86 -54\n"
				+ "-72 -50 59\n" + "21 65 -32\n" + "40 -94 87\n" + "-62 18 82", "638");
	}

	@Test
	void case4() {
		check("3 2\n" + "2000000000 -9000000000 4000000000\n" + "7000000000 -5000000000 3000000000\n"
				+ "6000000000 -1000000000 8000000000", "30000000000");
	}
}
