package abc.abc027;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1", "Aoki");
	}

	@Test
	void case2() {
		check("5", "Takahashi");
	}

	@Test
	void case3() {
		check("7", "Aoki");
	}

	@Test
	void case4() {
		check("10", "Takahashi");
	}

	@Test
	void case5() {
		check("123456789123456789", "Aoki");
	}
}
