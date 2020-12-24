package abc.abc051_100.abc063;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("uncopyrightable", "yes");
	}

	@Test
	void case2() {
		check("different", "no");
	}

	@Test
	void case3() {
		check("no", "yes");
	}
}
