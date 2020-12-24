package abc.abc051_100.abc070;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

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
