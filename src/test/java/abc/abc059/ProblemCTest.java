package abc.abc059;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 -3 1 0", "4");
	}

	@Test
	void case2() {
		check("5\n" + "3 -6 4 -5 7", "0");
	}

	@Test
	void case3() {
		check("6\n" + "-1 4 3 2 -5 4", "8");
	}
}
