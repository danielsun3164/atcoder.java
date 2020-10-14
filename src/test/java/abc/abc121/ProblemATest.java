package abc.abc121;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "2 1", "1");
	}

	@Test
	void case2() {
		check("5 5\n" + "2 3", "6");
	}

	@Test
	void case3() {
		check("2 4\n" + "2 4", "0");
	}
}
