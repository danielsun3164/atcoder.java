package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "1 2 3 4 5\n" + "1 0 5\n" + "1 2 4\n" + "0 3 10\n" + "1 0 5\n" + "1 0 3",
				"15" + LF + "7" + LF + "25" + LF + "6");
	}
}
