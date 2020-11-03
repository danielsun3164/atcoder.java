package abc.abc041;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "2 1\n" + "2 3", "2");
	}

	@Test
	void case2() {
		check("5 5\n" + "1 2\n" + "2 3\n" + "3 5\n" + "1 4\n" + "4 5", "3");
	}

	@Test
	void case3() {
		check("16 1\n" + "1 2", "10461394944000");
	}
}
