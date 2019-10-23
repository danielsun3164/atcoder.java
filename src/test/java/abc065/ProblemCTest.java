package abc065;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 2");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void test_Case2() {
		in.input("3 2");
		ProblemC.main(null);
		assertResultIs("12");
	}

	@Test
	void test_Case3() {
		in.input("1 8");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case4() {
		in.input("100000 100000");
		ProblemC.main(null);
		assertResultIs("530123477");
	}
}
