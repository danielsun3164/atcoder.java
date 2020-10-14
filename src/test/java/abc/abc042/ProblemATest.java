package abc.abc042;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 5 7", "YES");
	}

	@Test
	void case2() {
		check("7 7 5", "NO");
	}
}
