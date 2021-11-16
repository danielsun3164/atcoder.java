package abc.abc151_200.abc152;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2\n" + "2 3\n" + "1\n" + "1 3", "3");
	}

	@Test
	void case2() {
		check("2\n" + "1 2\n" + "1\n" + "1 2", "1");
	}

	@Test
	void case3() {
		check("5\n" + "1 2\n" + "3 2\n" + "3 4\n" + "5 3\n" + "3\n" + "1 3\n" + "2 4\n" + "2 5", "9");
	}

	@Test
	void case4() {
		check("8\n" + "1 2\n" + "2 3\n" + "4 3\n" + "2 5\n" + "6 3\n" + "6 7\n" + "8 6\n" + "5\n" + "2 7\n" + "3 5\n"
				+ "1 6\n" + "2 8\n" + "7 8", "62");
	}
}
