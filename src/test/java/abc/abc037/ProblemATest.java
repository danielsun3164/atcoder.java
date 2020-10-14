package abc.abc037;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 5 6", "2");
	}

	@Test
	void case2() {
		check("8 6 20", "3");
	}
}
