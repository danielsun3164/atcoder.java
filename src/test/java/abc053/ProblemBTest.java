package abc053;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("QWERTYASDFZXCV");
		ProblemB.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("ZABCZ");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void case3() {
		in.input("HASFJGHOGAKZZFEGA");
		ProblemB.main(null);
		assertResultIs("12");
	}
}
