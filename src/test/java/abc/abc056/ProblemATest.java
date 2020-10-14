package abc.abc056;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("H H", "H");
	}

	@Test
	void case2() {
		check("D H", "D");
	}

	@Test
	void case3() {
		check("D D", "H");
	}
}
