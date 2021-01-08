package abc.abc001_050.abc038;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 3\n" + "1 1\n" + "2 2", "3");
	}

	@Test
	void case2() {
		check("2\n" + "4 5\n" + "4 3", "1");
	}

	@Test
	void case3() {
		check("4\n" + "2 5\n" + "3 3\n" + "4 5\n" + "6 6", "3");
	}

	@Test
	void case4() {
		check("5\n" + "8 8\n" + "5 3\n" + "2 2\n" + "4 2\n" + "2 1", "4");
	}
}
