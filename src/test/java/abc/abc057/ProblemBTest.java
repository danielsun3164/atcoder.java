package abc.abc057;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "2 0\n" + "0 0\n" + "-1 0\n" + "1 0", "2" + LF + "1");
	}

	@Test
	void case2() {
		check("3 4\n" + "10 10\n" + "-10 -10\n" + "3 3\n" + "1 2\n" + "2 3\n" + "3 5\n" + "3 5",
				"3" + LF + "1" + LF + "2");
	}

	@Test
	void case3() {
		check("5 5\n" + "-100000000 -100000000\n" + "-100000000 100000000\n" + "100000000 -100000000\n"
				+ "100000000 100000000\n" + "0 0\n" + "0 0\n" + "100000000 100000000\n" + "100000000 -100000000\n"
				+ "-100000000 100000000\n" + "-100000000 -100000000", "5" + LF + "4" + LF + "3" + LF + "2" + LF + "1");
	}
}
