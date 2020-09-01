package abc.abc070;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("575", "Yes");
	}

	@Test
	void case2() {
		check("123", "No");
	}

	@Test
	void case3() {
		check("812", "No");
	}
}
