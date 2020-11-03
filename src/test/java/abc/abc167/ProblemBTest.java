package abc.abc167;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 1 1 3", "2");
	}

	@Test
	void case2() {
		check("1 2 3 4", "0");
	}

	@Test
	void case3() {
		check("2000000000 0 0 2000000000", "2000000000");
	}
}
