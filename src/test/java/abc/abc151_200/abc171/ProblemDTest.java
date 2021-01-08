package abc.abc151_200.abc171;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 2 3 4\n" + "3\n" + "1 2\n" + "3 4\n" + "2 4", "11" + LF + "12" + LF + "16");
	}

	@Test
	void case2() {
		check("4\n" + "1 1 1 1\n" + "3\n" + "1 2\n" + "2 1\n" + "3 5", "8" + LF + "4" + LF + "4");
	}

	@Test
	void case3() {
		check("2\n" + "1 2\n" + "3\n" + "1 100\n" + "2 100\n" + "100 1000", "102" + LF + "200" + LF + "2000");
	}
}
