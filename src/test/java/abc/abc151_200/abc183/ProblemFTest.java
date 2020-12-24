package abc.abc151_200.abc183;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "1 2 3 2 1\n" + "1 1 2\n" + "1 2 5\n" + "2 1 1\n" + "1 3 4\n" + "2 3 4", "2" + LF + "0");
	}

	@Test
	void case2() {
		check("5 4\n" + "2 2 2 2 2\n" + "1 1 2\n" + "1 1 3\n" + "1 2 3\n" + "2 2 2", "3");
	}

	@Test
	void case3() {
		check("12 9\n" + "1 2 3 1 2 3 1 2 3 1 2 3\n" + "1 1 2\n" + "1 3 4\n" + "1 5 6\n" + "1 7 8\n" + "2 2 1\n"
				+ "1 9 10\n" + "2 5 6\n" + "1 4 8\n" + "2 6 1", "1" + LF + "0" + LF + "0");
	}
}
