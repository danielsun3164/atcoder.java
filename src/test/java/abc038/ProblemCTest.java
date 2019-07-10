package abc038;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5\n" + "1 2 3 2 1");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void test_Case2() {
		in.input("4\n" + "1 2 3 4");
		ProblemC.main(null);
		assertResultIs("10");
	}

	@Test
	void test_Case3() {
		in.input("6\n" + "3 3 4 1 2 2");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void test_Case4() {
		in.input("6\n" + "1 5 2 3 4 2");
		ProblemC.main(null);
		assertResultIs("10");
	}
}
