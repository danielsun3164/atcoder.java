package abc046;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("gpg");
		ProblemD.main(null);
		assertResultIs("0");
	}

	@Test
	void case2() {
		in.input("ggppgggpgg");
		ProblemD.main(null);
		assertResultIs("2");
	}
}
