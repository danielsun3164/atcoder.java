package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemLTest extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "0 1 0 0 1\n" + "2 1 5\n" + "1 3 4\n" + "2 2 5\n" + "1 1 3\n" + "2 1 2",
				"2" + LF + "0" + LF + "1");
	}
}
