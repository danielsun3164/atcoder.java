package abc.abc151_200.abc167;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 5\n" + "3 2 4 1", "4");
	}

	@Test
	void case2() {
		check("6 727202214173249351\n" + "6 5 2 5 3 2", "2");
	}

	@Test
	void case3() {
		check("4 2\n" + "3 2 4 1", "4");
	}
}
