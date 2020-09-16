package abc.abc118;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 12", "16");
	}

	@Test
	void case2() {
		check("8 20", "12");
	}

	@Test
	void case3() {
		check("1 1", "2");
	}
}
