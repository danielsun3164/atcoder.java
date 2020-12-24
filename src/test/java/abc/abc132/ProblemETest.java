package abc.abc132;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 1\n" + "1 3", "2");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 2\n" + "2 3\n" + "3 1\n" + "1 2", "-1");
	}

	@Test
	void case3() {
		check("2 0\n" + "1 2", "-1");
	}

	@Test
	void case4() {
		check("6 8\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "5 1\n" + "1 4\n" + "1 5\n" + "4 6\n" + "1 6", "2");
	}
}
