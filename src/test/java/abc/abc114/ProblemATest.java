package abc.abc114;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5", "YES");
	}

	@Test
	void case2() {
		check("6", "NO");
	}
}
