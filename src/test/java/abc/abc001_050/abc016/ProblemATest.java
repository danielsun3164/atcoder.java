package abc.abc001_050.abc016;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 1", "YES");
	}

	@Test
	void case2() {
		check("2 29", "NO");
	}

	@Test
	void case3() {
		check("12 6", "YES");
	}
}
