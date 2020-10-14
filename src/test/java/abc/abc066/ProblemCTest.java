package abc.abc066;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 2 3 4", "4 2 1 3");
	}

	@Test
	void case2() {
		check("3\n" + "1 2 3", "3 1 2");
	}

	@Test
	void case3() {
		check("1\n" + "1000000000", "1000000000");
	}

	@Test
	void case4() {
		check("6\n" + "0 6 7 6 7 0", "0 6 6 0 7 7");
	}
}
