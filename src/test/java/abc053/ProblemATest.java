package abc053;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("1000");
		ProblemA.main(null);
		assertResultIs("ABC");
	}

	@Test
	void case2() {
		in.input("2000");
		ProblemA.main(null);
		assertResultIs("ARC");
	}
}
