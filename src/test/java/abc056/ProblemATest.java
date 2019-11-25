package abc056;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("H H");
		ProblemA.main(null);
		assertResultIs("H");
	}

	@Test
	void case2() {
		in.input("D H");
		ProblemA.main(null);
		assertResultIs("D");
	}

	@Test
	void case3() {
		in.input("D D");
		ProblemA.main(null);
		assertResultIs("H");
	}
}
