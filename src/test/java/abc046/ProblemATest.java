package abc046;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("3 1 4");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("3 3 33");
		ProblemA.main(null);
		assertResultIs("2");
	}
}
