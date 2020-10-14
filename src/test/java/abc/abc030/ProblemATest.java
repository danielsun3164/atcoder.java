package abc.abc030;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 2 6 3", "AOKI");
	}

	@Test
	void case2() {
		check("100 80 100 73", "TAKAHASHI");
	}

	@Test
	void case3() {
		check("66 30 55 25", "DRAW");
	}
}
