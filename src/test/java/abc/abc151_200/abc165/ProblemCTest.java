package abc.abc151_200.abc165;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 4 3\n" + "1 3 3 100\n" + "1 2 2 10\n" + "2 3 2 10", "110");
	}

	@Test
	void case2() {
		check("4 6 10\n" + "2 4 1 86568\n" + "1 4 0 90629\n" + "2 3 0 90310\n" + "3 4 1 29211\n" + "3 4 3 78537\n"
				+ "3 4 2 8580\n" + "1 2 1 96263\n" + "1 4 2 2156\n" + "1 2 0 94325\n" + "1 4 3 94328", "357500");
	}

	@Test
	void case3() {
		check("10 10 1\n" + "1 10 9 1", "1");
	}
}
