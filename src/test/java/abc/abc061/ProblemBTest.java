package abc.abc061;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "1 2\n" + "2 3\n" + "1 4", "2" + LF + "2" + LF + "1" + LF + "1");
	}

	@Test
	void case2() {
		check("2 5\n" + "1 2\n" + "2 1\n" + "1 2\n" + "2 1\n" + "1 2", "5" + LF + "5");
	}

	@Test
	void case3() {
		check("8 8\n" + "1 2\n" + "3 4\n" + "1 5\n" + "2 8\n" + "3 7\n" + "5 2\n" + "4 1\n" + "6 8",
				"3" + LF + "3" + LF + "2" + LF + "2" + LF + "2" + LF + "1" + LF + "1" + LF + "2");
	}
}
