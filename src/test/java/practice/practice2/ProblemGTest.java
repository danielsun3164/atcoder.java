package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("6 7\n" + "1 4\n" + "5 2\n" + "3 0\n" + "5 5\n" + "4 1\n" + "0 3\n" + "4 2",
				"4" + LF + "1 5" + LF + "2 4 1" + LF + "1 2" + LF + "2 3 0");
	}
}
