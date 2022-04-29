package abc.abc201_250.abc214;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 10\n" + "2 3 20", "50");
	}

	@Test
	void case2() {
		check("5\n" + "1 2 1\n" + "2 3 2\n" + "4 2 5\n" + "3 5 14", "76");
	}
}
