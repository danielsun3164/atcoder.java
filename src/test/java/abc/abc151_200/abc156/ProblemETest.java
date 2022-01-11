package abc.abc151_200.abc156;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 2", "10");
	}

	@Test
	void case2() {
		check("200000 1000000000", "607923868");
	}

	@Test
	void case3() {
		check("15 6", "22583772");
	}
}
