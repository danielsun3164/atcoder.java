package abc103;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 6 3", "5");
	}

	@Test
	void case2() {
		check("11 5 5", "6");
	}

	@Test
	void case3() {
		check("100 100 100", "0");
	}
}
