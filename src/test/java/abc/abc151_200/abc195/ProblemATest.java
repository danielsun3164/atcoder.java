package abc.abc151_200.abc195;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("10 120", "Yes");
	}

	@Test
	void case2() {
		check("10 125", "No");
	}
}
