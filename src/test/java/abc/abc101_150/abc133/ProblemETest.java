package abc.abc101_150.abc133;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "1 2\n" + "2 3\n" + "3 4", "6");
	}

	@Test
	void case2() {
		check("5 4\n" + "1 2\n" + "1 3\n" + "1 4\n" + "4 5", "48");
	}

	@Test
	void case3() {
		check("16 22\n" + "12 1\n" + "3 1\n" + "4 16\n" + "7 12\n" + "6 2\n" + "2 15\n" + "5 16\n" + "14 16\n"
				+ "10 11\n" + "3 10\n" + "3 13\n" + "8 6\n" + "16 8\n" + "9 12\n" + "4 3", "271414432");
	}
}
