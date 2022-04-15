package other.atc002;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("12 15 7", "3");
	}

	@Test
	void case2() {
		check("123456789 234567894 6574837563712", "120678297");
	}
}
