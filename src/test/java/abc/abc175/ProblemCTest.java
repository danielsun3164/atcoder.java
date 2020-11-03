package abc.abc175;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6 2 4", "2");
	}

	@Test
	void case2() {
		check("7 4 3", "1");
	}

	@Test
	void case3() {
		check("10 1 2", "8");
	}

	@Test
	void case4() {
		check("1000000000000000 1000000000000000 1000000000000000", "1000000000000000");
	}
}
