package abc.abc151_200.abc191;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("10 3 5 20", "Yes");
	}

	@Test
	void case2() {
		check("10 3 5 30", "No");
	}
}
