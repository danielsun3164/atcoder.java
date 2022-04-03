package abc.abc201_250.abc214;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1 0", "4");
	}

	@Test
	void case2() {
		check("2 5", "10");
	}

	@Test
	void case3() {
		check("10 10", "213");
	}

	@Test
	void case4() {
		check("30 100", "2471");
	}
}
