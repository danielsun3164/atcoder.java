package abc010;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("chokudai");
		ProblemA.main(null);
		assertResultIs("chokudaipp");
	}

	@Test
	void test_Case2() {
		in.input("sanagi");
		ProblemA.main(null);
		assertResultIs("sanagipp");
	}
}
