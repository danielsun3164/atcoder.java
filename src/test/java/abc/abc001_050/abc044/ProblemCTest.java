package abc.abc001_050.abc044;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 8\n" + "7 9 8 9", "5");
	}

	@Test
	void case2() {
		check("3 8\n" + "6 6 9", "0");
	}

	@Test
	void case3() {
		check("8 5\n" + "3 6 2 8 7 6 5 9", "19");
	}

	@Test
	void case4() {
		check("33 3\n" + "3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3", "8589934591");
	}
}
