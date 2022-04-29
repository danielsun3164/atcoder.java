package abc.abc151_200.abc162;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("117", "Yes");
	}

	@Test
	void case2() {
		check("123", "No");
	}

	@Test
	void case3() {
		check("777", "Yes");
	}
}
