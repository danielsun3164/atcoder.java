package abc.abc201_250.abc211;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 5\n" + "2 4\n" + "1 2\n" + "2 3\n" + "1 3\n" + "3 4", "2");
	}

	@Test
	void case2() {
		check("4 3\n" + "1 3\n" + "2 3\n" + "2 4", "1");
	}

	@Test
	void case3() {
		check("2 0", "0");
	}

	@Test
	void case4() {
		check("7 8\n" + "1 3\n" + "1 4\n" + "2 3\n" + "2 4\n" + "2 5\n" + "2 6\n" + "5 7\n" + "6 7", "4");
	}
}
