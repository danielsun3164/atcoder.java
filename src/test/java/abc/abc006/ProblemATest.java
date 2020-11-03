package abc.abc006;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2", "NO");
	}

	@Test
	void case2() {
		check("9", "YES");
	}

	@Test
	void case3() {
		check("3", "YES");
	}
}
