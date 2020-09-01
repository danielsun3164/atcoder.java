package abc.abc068;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("7", "4");
	}

	@Test
	void case2() {
		check("32", "32");
	}

	@Test
	void case3() {
		check("1", "1");
	}

	@Test
	void case4() {
		check("100", "64");
	}
}
