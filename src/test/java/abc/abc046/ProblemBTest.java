package abc.abc046;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 2", "2");
	}

	@Test
	void case2() {
		check("1 10", "10");
	}

	@Test
	void case3() {
		check("10 8", "322828856");
	}
}
