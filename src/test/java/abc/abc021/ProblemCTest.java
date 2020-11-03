package abc.abc021;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "1 7\n" + "8\n" + "1 2\n" + "1 3\n" + "4 2\n" + "4 3\n" + "4 5\n" + "4 6\n" + "7 5\n" + "7 6",
				"4");
	}

	@Test
	void case2() {
		check("7\n" + "1 7\n" + "9\n" + "1 2\n" + "1 3\n" + "4 2\n" + "4 3\n" + "4 5\n" + "4 6\n" + "7 5\n" + "7 6\n"
				+ "4 7", "2");
	}
}
