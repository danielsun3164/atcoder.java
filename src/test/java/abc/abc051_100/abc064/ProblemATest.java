package abc.abc051_100.abc064;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 3 2", "YES");
	}

	@Test
	void case2() {
		check("2 3 4", "NO");
	}
}
