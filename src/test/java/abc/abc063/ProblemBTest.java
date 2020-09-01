package abc.abc063;

import org.junit.jupiter.api.Test;

import practice.TestBase;

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
