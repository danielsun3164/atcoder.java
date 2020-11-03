package abc.abc023;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("23", "5");
	}

	@Test
	void case2() {
		check("70", "7");
	}

	@Test
	void case3() {
		check("99", "18");
	}
}
