package abc064;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "2 3 7 9", "7");
	}

	@Test
	void case2() {
		check("8\n" + "3 1 4 1 5 9 2 6", "8");
	}
}
