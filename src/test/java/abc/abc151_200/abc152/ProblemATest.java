package abc.abc151_200.abc152;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 3", "Yes");
	}

	@Test
	void case2() {
		check("3 2", "No");
	}

	@Test
	void case3() {
		check("1 1", "Yes");
	}
}
