package abc043;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2\n" + "4 8");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void test_Case2() {
		in.input("3\n" + "1 1 3");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case3() {
		in.input("3\n" + "4 2 5");
		ProblemC.main(null);
		assertResultIs("5");
	}

	@Test
	void test_Case4() {
		in.input("4\n" + "-100 -100 -100 -100");
		ProblemC.main(null);
		assertResultIs("0");
	}
}
