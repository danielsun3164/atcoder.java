package abc019;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 3 4");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("5 100 5");
		ProblemA.main(null);
		assertResultIs("5");
	}

	@Test
	void test_Case3() {
		in.input("3 3 3");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case4() {
		in.input("3 3 4");
		ProblemA.main(null);
		assertResultIs("3");
	}
}
