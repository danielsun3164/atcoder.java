package abc.abc006;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "1\n" + "3\n" + "5\n" + "2\n" + "4\n" + "6", "2");
	}

	@Test
	void case2() {
		check("5\n" + "5\n" + "4\n" + "3\n" + "2\n" + "1", "4");
	}

	@Test
	void case3() {
		check("7\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7", "0");
	}
}
