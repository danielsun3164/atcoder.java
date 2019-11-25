package abc010;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("chokudai");
		ProblemA.main(null);
		assertResultIs("chokudaipp");
	}

	@Test
	void case2() {
		in.input("sanagi");
		ProblemA.main(null);
		assertResultIs("sanagipp");
	}
}
