package abc.abc055;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3", "6");
	}

	@Test
	void case2() {
		check("10", "3628800");
	}

	@Test
	void case3() {
		check("100000", "457992974");
	}
}
