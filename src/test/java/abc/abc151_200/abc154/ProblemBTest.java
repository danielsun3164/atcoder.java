package abc.abc151_200.abc154;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("sardine", "xxxxxxx");
	}

	@Test
	void case2() {
		check("xxxx", "xxxx");
	}

	@Test
	void case3() {
		check("gone", "xxxx");
	}
}
