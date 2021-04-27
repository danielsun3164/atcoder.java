package abc.abc151_200.abc199;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 2 4", "Yes");
	}

	@Test
	void case2() {
		check("10 10 10", "No");
	}

	@Test
	void case3() {
		check("3 4 5", "No");
	}
}
