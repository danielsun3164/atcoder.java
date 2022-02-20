package abc.abc151_200.abc160;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("sippuu", "Yes");
	}

	@Test
	void case2() {
		check("iphone", "No");
	}

	@Test
	void case3() {
		check("coffee", "Yes");
	}
}
