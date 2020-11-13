package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 7\n" + "1 0 1\n" + "0 0 1\n" + "0 2 3\n" + "1 0 1\n" + "1 1 2\n" + "0 0 2\n" + "1 1 3",
				"0" + LF + "1" + LF + "0" + LF + "1");
	}
}
