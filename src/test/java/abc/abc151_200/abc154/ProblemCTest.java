package abc.abc151_200.abc154;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "2 6 1 4 5", "YES");
	}

	@Test
	void case2() {
		check("6\n" + "4 1 3 1 6 2", "NO");
	}

	@Test
	void case3() {
		check("2\n" + "10000000 10000000", "NO");
	}
}
