package abc062;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 3", "Yes");
	}

	@Test
	void case2() {
		check("2 4", "No");
	}
}
