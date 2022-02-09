package abc.abc151_200.abc158;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("8 3 4", "4");
	}

	@Test
	void case2() {
		check("8 0 4", "0");
	}

	@Test
	void case3() {
		check("6 2 4", "2");
	}
}
