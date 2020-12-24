package abc.abc151_200.abc172;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 4 240\n" + "60 90 120\n" + "80 150 80 150", "3");
	}

	@Test
	void case2() {
		check("3 4 730\n" + "60 90 120\n" + "80 150 80 150", "7");
	}

	@Test
	void case3() {
		check("5 4 1\n" + "1000000000 1000000000 1000000000 1000000000 1000000000\n"
				+ "1000000000 1000000000 1000000000 1000000000", "0");
	}
}
