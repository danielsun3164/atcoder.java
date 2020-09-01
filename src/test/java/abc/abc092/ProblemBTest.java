package abc.abc092;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "7 1\n" + "2\n" + "5\n" + "10", "8");
	}

	@Test
	void case2() {
		check("2\n" + "8 20\n" + "1\n" + "10", "29");
	}

	@Test
	void case3() {
		check("5\n" + "30 44\n" + "26\n" + "18\n" + "81\n" + "18\n" + "6", "56");
	}
}
