package abc.abc019;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 3 4", "3");
	}

	@Test
	void case2() {
		check("5 100 5", "5");
	}

	@Test
	void case3() {
		check("3 3 3", "3");
	}

	@Test
	void case4() {
		check("3 3 4", "3");
	}
}
