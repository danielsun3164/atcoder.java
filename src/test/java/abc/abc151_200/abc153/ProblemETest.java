package abc.abc151_200.abc153;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("9 3\n" + "8 3\n" + "4 2\n" + "2 1", "4");
	}

	@Test
	void case2() {
		check("100 6\n" + "1 1\n" + "2 3\n" + "3 9\n" + "4 27\n" + "5 81\n" + "6 243", "100");
	}

	@Test
	void case3() {
		check("9999 10\n" + "540 7550\n" + "691 9680\n" + "700 9790\n" + "510 7150\n" + "415 5818\n" + "551 7712\n"
				+ "587 8227\n" + "619 8671\n" + "588 8228\n" + "176 2461", "139815");
	}
}
