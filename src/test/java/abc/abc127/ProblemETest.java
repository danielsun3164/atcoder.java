package abc.abc127;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 2 2", "8");
	}

	@Test
	void case2() {
		check("4 5 4", "87210");
	}

	@Test
	void case3() {
		check("100 100 5000", "817260251");
	}
}
