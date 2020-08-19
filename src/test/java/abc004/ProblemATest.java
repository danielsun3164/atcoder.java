package abc004;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1000", "2000");
	}

	@Test
	void case2() {
		check("1000000", "2000000");
	}

	@Test
	void case3() {
		check("0", "0");
	}
}
