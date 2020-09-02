package abc.abc112;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 70\n" + "7 60\n" + "1 80\n" + "4 50", "4");
	}

	@Test
	void case2() {
		check("4 3\n" + "1 1000\n" + "2 4\n" + "3 1000\n" + "4 500", "TLE");
	}

	@Test
	void case3() {
		check("5 9\n" + "25 8\n" + "5 9\n" + "4 10\n" + "1000 1000\n" + "6 1", "5");
	}
}
