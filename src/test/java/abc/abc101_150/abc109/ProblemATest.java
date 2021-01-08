package abc.abc101_150.abc109;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 1", "Yes");
	}

	@Test
	void case2() {
		check("1 2", "No");
	}

	@Test
	void case3() {
		check("2 2", "No");
	}
}
