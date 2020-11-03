package abc.abc083;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 8 7 1", "Left");
	}

	@Test
	void case2() {
		check("3 4 5 2", "Balanced");
	}

	@Test
	void case3() {
		check("1 7 6 4", "Right");
	}
}
