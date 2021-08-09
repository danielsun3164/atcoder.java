package abc.abc201_250.abc203;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 7 0\n" + "5 8 11\n" + "10 4 2", "4");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 2 3\n" + "4 5 6\n" + "7 8 9", "5");
	}
}
