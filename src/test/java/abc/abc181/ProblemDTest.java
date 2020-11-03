package abc.abc181;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("1234", "Yes");
	}

	@Test
	void case2() {
		check("1333", "No");
	}

	@Test
	void case3() {
		check("8", "Yes");
	}

	@Test
	void case4() {
		check("4", "No");
	}
}
