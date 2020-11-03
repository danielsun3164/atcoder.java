package abc.abc016;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1 0 1", "?");
	}

	@Test
	void case2() {
		check("1 1 2", "+");
	}

	@Test
	void case3() {
		check("1 1 0", "-");
	}

	@Test
	void case4() {
		check("1 1 1", "!");
	}
}
