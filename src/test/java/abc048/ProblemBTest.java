package abc048;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4 8 2");
		ProblemB.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("0 5 1");
		ProblemB.main(null);
		assertResultIs("6");
	}

	@Test
	void test_Case3() {
		in.input("9 9 2");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case4() {
		in.input("1 1000000000000000000 3");
		ProblemB.main(null);
		assertResultIs("333333333333333333");
	}
}
