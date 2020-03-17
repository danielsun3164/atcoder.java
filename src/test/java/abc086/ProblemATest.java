package abc086;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("3 4");
		ProblemA.main(null);
		assertResultIs("Even");
	}

	@Test
	void case2() {
		in.input("1 21");
		ProblemA.main(null);
		assertResultIs("Odd");
	}

	@Test
	void case3() {
		in.input("10000 10000");
		ProblemA.main(null);
		assertResultIs("Even");
	}
}
