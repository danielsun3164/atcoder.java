package abc.abc005;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1\n" + "2\n" + "3", "1");
	}

	@Test
	void case2() {
		check("3\n" + "3\n" + "3\n" + "3", "3");
	}

	@Test
	void case3() {
		check("5\n" + "3\n" + "1\n" + "4\n" + "1\n" + "5", "1");
	}
}
