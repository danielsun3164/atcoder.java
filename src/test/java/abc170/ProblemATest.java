package abc170;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("0 2 3 4 5");
		ProblemA.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("1 2 0 4 5");
		ProblemA.main(null);
		assertResultIs("3");
	}
}
