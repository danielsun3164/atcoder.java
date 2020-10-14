package abc.abc047;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("10 30 20", "Yes");
	}

	@Test
	void case2() {
		check("30 30 100", "No");
	}

	@Test
	void case3() {
		check("56 25 31", "Yes");
	}
}
