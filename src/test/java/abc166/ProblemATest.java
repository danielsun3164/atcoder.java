package abc166;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("ABC");
		ProblemA.main(null);
		assertResultIs("ARC");
	}

	@Test
	void case2() {
		in.input("ARC");
		ProblemA.main(null);
		assertResultIs("ABC");
	}
}
