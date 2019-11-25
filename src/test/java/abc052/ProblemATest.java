package abc052;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("3 5 2 7");
		ProblemA.main(null);
		assertResultIs("15");
	}

	@Test
	void case2() {
		in.input("100 600 200 300");
		ProblemA.main(null);
		assertResultIs("60000");
	}
}
