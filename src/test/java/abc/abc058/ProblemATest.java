package abc.abc058;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 4 6", "YES");
	}

	@Test
	void case2() {
		check("2 5 6", "NO");
	}

	@Test
	void case3() {
		check("3 2 1", "YES");
	}
}
