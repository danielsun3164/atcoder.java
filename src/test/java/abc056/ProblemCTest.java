package abc056;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("6");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("2");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case3() {
		in.input("11");
		ProblemC.main(null);
		assertResultIs("5");
	}

	@Test
	void test_Case4() {
		in.input("10");
		ProblemC.main(null);
		assertResultIs("4");
	}
}
