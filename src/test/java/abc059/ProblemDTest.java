package abc059;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 1");
		ProblemD.main(null);
		assertResultIs("Brown");
	}

	@Test
	void test_Case2() {
		in.input("5 0");
		ProblemD.main(null);
		assertResultIs("Alice");
	}

	@Test
	void test_Case3() {
		in.input("0 0");
		ProblemD.main(null);
		assertResultIs("Brown");
	}

	@Test
	void test_Case4() {
		in.input("4 8");
		ProblemD.main(null);
		assertResultIs("Alice");
	}
}
