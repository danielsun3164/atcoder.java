package abc.abc047;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "100 50 200", "1");
	}

	@Test
	void case2() {
		check("5 8\n" + "50 30 40 10 20", "2");
	}

	@Test
	void case3() {
		check("10 100\n" + "7 10 4 5 9 3 6 8 2 1", "2");
	}
}
