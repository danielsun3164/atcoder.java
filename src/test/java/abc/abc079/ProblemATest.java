package abc.abc079;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1118", "Yes");
	}

	@Test
	void case2() {
		check("7777", "Yes");
	}

	@Test
	void case3() {
		check("1234", "No");
	}
}
