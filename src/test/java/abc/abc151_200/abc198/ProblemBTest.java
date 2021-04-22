package abc.abc151_200.abc198;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1210", "Yes");
	}

	@Test
	void case2() {
		check("777", "Yes");
	}

	@Test
	void case3() {
		check("123456789", "No");
	}

	@Test
	void case4() {
		check("0", "Yes");
	}
}
