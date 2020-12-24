package abc.abc132;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("ASSA", "Yes");
	}

	@Test
	void case2() {
		check("STOP", "No");
	}

	@Test
	void case3() {
		check("FFEE", "Yes");
	}

	@Test
	void case4() {
		check("FREE", "No");
	}
}
