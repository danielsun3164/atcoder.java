package abc010;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5 8 2", "4");
	}

	@Test
	void case2() {
		check("9\n" + "1 2 3 4 5 6 7 8 9", "8");
	}
}
