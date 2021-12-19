package abc.abc201_250.abc212;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("50 50", "Alloy");
	}

	@Test
	void case2() {
		check("100 0", "Gold");
	}

	@Test
	void case3() {
		check("0 100", "Silver");
	}

	@Test
	void case4() {
		check("100 2", "Alloy");
	}
}
