package abc.abc201_250.abc208;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 11", "Yes");
	}

	@Test
	void case2() {
		check("2 13", "No");
	}

	@Test
	void case3() {
		check("100 600", "Yes");
	}
}
