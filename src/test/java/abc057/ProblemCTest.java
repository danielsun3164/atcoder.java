package abc057;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("10000");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("1000003");
		ProblemC.main(null);
		assertResultIs("7");
	}

	@Test
	void test_Case3() {
		in.input("9876543210");
		ProblemC.main(null);
		assertResultIs("6");
	}

	@Test
	void test_Case4() {
		in.input("100000007");
		ProblemC.main(null);
		assertResultIs("9");
	}
}
