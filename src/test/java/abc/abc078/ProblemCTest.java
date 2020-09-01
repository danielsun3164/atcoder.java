package abc.abc078;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 1", "3800");
	}

	@Test
	void case2() {
		check("10 2", "18400");
	}

	@Test
	void case3() {
		check("100 5", "608000");
	}
}
