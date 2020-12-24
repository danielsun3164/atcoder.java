package abc.abc051_100.abc060;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("7 5 1", "YES");
	}

	@Test
	void case2() {
		check("2 2 1", "NO");
	}

	@Test
	void case3() {
		check("1 100 97", "YES");
	}

	@Test
	void case4() {
		check("40 98 58", "YES");
	}

	@Test
	void case5() {
		check("77 42 36", "NO");
	}
}
