package abc.abc001_050.abc021;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 5\n" + "3\n" + "3 4 2", "YES");
	}

	@Test
	void case2() {
		check("7\n" + "1 3\n" + "4\n" + "2 4 2 7", "NO");
	}

	@Test
	void case3() {
		check("4\n" + "1 4\n" + "3\n" + "2 1 3", "NO");
	}

	@Test
	void case4() {
		check("4\n" + "1 4\n" + "3\n" + "2 4 3", "NO");
	}

	@Test
	void case5() {
		check("20\n" + "1 4\n" + "12\n" + "2 3 5 7 8 9 10 11 12 15 13 14", "YES");
	}
}
