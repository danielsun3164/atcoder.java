package abc.abc064;

import org.junit.jupiter.api.Test;

import practice.TestBase;

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
