package abc.abc151_200.abc153;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 1\n" + "4 1 5", "5");
	}

	@Test
	void case2() {
		check("8 9\n" + "7 9 3 2 3 8 4 6", "0");
	}

	@Test
	void case3() {
		check("3 0\n" + "1000000000 1000000000 1000000000", "3000000000");
	}
}
