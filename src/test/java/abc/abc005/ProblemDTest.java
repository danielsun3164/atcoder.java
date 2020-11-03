package abc.abc005;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 2 1\n" + "2 2 1\n" + "1 1 1\n" + "3\n" + "1\n" + "4\n" + "9", "3\n" + "9\n" + "14");
	}

	@Test
	void case2() {
		check("3\n" + "1 1 1\n" + "1 1 1\n" + "9 9 9\n" + "1\n" + "4", "27");
	}
}
