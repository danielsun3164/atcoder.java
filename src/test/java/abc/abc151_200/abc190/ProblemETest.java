package abc.abc151_200.abc190;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "1 4\n" + "2 4\n" + "3 4\n" + "3\n" + "1 2 3", "5");
	}

	@Test
	void case2() {
		check("4 3\n" + "1 4\n" + "2 4\n" + "1 2\n" + "3\n" + "1 2 3", "-1");
	}

	@Test
	void case3() {
		check("10 10\n" + "3 9\n" + "3 8\n" + "8 10\n" + "2 10\n" + "5 8\n" + "6 8\n" + "5 7\n" + "6 7\n" + "1 6\n"
				+ "2 4\n" + "4\n" + "1 2 7 9", "11");
	}
}
