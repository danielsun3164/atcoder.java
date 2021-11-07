package abc.abc151_200.abc151;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 2\n" + "1 1 3 4", "11");
	}

	@Test
	void case2() {
		check("6 3\n" + "10 10 10 -10 -10 -10", "360");
	}

	@Test
	void case3() {
		check("3 1\n" + "1 1 1", "0");
	}

	@Test
	void case4() {
		check("10 6\n" + "1000000000 1000000000 1000000000 1000000000 1000000000 0 0 0 0 0", "999998537");
	}
}
