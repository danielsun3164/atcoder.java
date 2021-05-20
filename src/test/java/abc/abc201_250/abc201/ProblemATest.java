package abc.abc201_250.abc201;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 1 3", "Yes");
	}

	@Test
	void case2() {
		check("1 4 3", "No");
	}

	@Test
	void case3() {
		check("5 5 5", "Yes");
	}
}
