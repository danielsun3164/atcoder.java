package abc.abc151_200.abc170;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6 5\n" + "4 7 10 6 5", "8");
	}

	@Test
	void case2() {
		check("10 5\n" + "4 7 10 6 5", "9");
	}

	@Test
	void case3() {
		check("100 0\n" + "", "100");
	}
}
