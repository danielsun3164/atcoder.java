package abc.abc151_200.abc190;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 1 0", "Takahashi");
	}

	@Test
	void case2() {
		check("2 2 0", "Aoki");
	}

	@Test
	void case3() {
		check("2 2 1", "Takahashi");
	}
}
