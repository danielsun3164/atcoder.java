package abc.abc022;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1\n" + "2\n" + "3\n" + "2\n" + "1", "2");
	}

	@Test
	void case2() {
		check("11\n" + "3\n" + "1\n" + "4\n" + "1\n" + "5\n" + "9\n" + "2\n" + "6\n" + "5\n" + "3\n" + "5", "4");
	}
}
