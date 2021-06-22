package abc.abc201_250.abc205;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3 1 2 4 5", "Yes");
	}

	@Test
	void case2() {
		check("6\n" + "3 1 4 1 5 2", "No");
	}

	@Test
	void case3() {
		check("3\n" + "1 2 3", "Yes");
	}

	@Test
	void case4() {
		check("1\n" + "1", "Yes");
	}
}
