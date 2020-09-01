package abc.abc046;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("gpg", "0");
	}

	@Test
	void case2() {
		check("ggppgggpgg", "2");
	}
}
