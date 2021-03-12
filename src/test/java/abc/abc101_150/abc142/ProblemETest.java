package abc.abc101_150.abc142;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "10 1\n" + "1\n" + "15 1\n" + "2\n" + "30 2\n" + "1 2", "25");
	}

	@Test
	void case2() {
		check("12 1\n" + "100000 1\n" + "2", "-1");
	}

	@Test
	void case3() {
		check("4 6\n" + "67786 3\n" + "1 3 4\n" + "3497 1\n" + "2\n" + "44908 3\n" + "2 3 4\n" + "2156 3\n" + "2 3 4\n"
				+ "26230 1\n" + "2\n" + "86918 1\n" + "3", "69942");
	}
}
