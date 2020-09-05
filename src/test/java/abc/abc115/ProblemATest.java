package abc.abc115;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("25", "Christmas");
	}

	@Test
	void case2() {
		check("22", "Christmas Eve Eve Eve");
	}
}
