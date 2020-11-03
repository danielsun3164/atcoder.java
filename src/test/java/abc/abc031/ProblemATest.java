package abc.abc031;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("31 87", "2784");
	}

	@Test
	void case2() {
		check("101 65", "6666");
	}

	@Test
	void case3() {
		check("3 3", "12");
	}
}
