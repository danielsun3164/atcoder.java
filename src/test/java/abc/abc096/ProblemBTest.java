package abc.abc096;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 3 11\n" + "1", "30");
	}

	@Test
	void case2() {
		check("3 3 4\n" + "2", "22");
	}
}
