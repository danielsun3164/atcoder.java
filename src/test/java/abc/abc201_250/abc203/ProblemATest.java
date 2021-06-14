package abc.abc201_250.abc203;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 5 2", "5");
	}

	@Test
	void case2() {
		check("4 5 6", "0");
	}

	@Test
	void case3() {
		check("1 1 1", "1");
	}
}
