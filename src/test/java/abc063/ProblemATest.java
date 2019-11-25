package abc063;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("6 3");
		ProblemA.main(null);
		assertResultIs("9");
	}

	@Test
	void case2() {
		in.input("6 4");
		ProblemA.main(null);
		assertResultIs("error");
	}
}
