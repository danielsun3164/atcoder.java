package abc.abc039;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 3 4", "52");
	}

	@Test
	void case2() {
		check("3 4 2", "52");
	}

	@Test
	void case3() {
		check("100 100 100", "60000");
	}

	@Test
	void case4() {
		check("1 1 1", "6");
	}
}
