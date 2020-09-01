package abc.abc172;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 2", "2");
	}

	@Test
	void case2() {
		check("2 3", "18");
	}

	@Test
	void case3() {
		check("141421 356237", "881613484");
	}
}
