package abc.abc151_200.abc187;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 2\n" + "1 3", "2");
	}

	@Test
	void case2() {
		check("4 6\n" + "1 2\n" + "1 3\n" + "1 4\n" + "2 3\n" + "2 4\n" + "3 4", "1");
	}

	@Test
	void case3() {
		check("10 11\n" + "9 10\n" + "2 10\n" + "8 9\n" + "3 4\n" + "5 8\n" + "1 8\n" + "5 6\n" + "2 5\n" + "3 6\n"
				+ "6 9\n" + "1 9", "5");
	}

	@Test
	void case4() {
		check("18 0", "18");
	}
}
