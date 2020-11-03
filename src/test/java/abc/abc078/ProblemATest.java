package abc.abc078;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("A B", "<");
	}

	@Test
	void case2() {
		check("E C", ">");
	}

	@Test
	void case3() {
		check("F F", "=");
	}
}
