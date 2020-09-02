package abc.abc111;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "3 1 3 2", "1");
	}

	@Test
	void case2() {
		check("6\n" + "105 119 105 119 105 119", "0");
	}

	@Test
	void case3() {
		check("4\n" + "1 1 1 1", "2");
	}
}
