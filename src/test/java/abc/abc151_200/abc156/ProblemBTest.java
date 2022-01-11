package abc.abc151_200.abc156;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("11 2", "4");
	}

	@Test
	void case2() {
		check("1010101 10", "7");
	}

	@Test
	void case3() {
		check("314159265 3", "18");
	}
}
