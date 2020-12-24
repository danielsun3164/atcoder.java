package abc.abc101_150.abc131;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 2", "18");
	}

	@Test
	void case2() {
		check("3 -1", "0");
	}

	@Test
	void case3() {
		check("30 -50", "-1044");
	}
}
