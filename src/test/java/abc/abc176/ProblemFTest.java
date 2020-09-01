package abc.abc176;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 2 1 2 2 1", "2");
	}

	@Test
	void case2() {
		check("3\n" + "1 1 2 2 3 3 3 2 1", "1");
	}

	@Test
	void case3() {
		check("3\n" + "1 1 2 2 2 3 3 3 1", "3");
	}
}
