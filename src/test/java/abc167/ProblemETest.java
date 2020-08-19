package abc167;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 2 1", "6");
	}

	@Test
	void case2() {
		check("100 100 0", "73074801");
	}

	@Test
	void case3() {
		check("60522 114575 7559", "479519525");
	}
}
