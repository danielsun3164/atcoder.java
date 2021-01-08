package abc.abc151_200.abc178;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1 2 1 1", "2");
	}

	@Test
	void case2() {
		check("3 5 -4 -2", "-6");
	}

	@Test
	void case3() {
		check("-1000000000 0 -1000000000 0", "1000000000000000000");
	}
}
