package abc071;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("6\n" + "3 1 2 4 2 1");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("4\n" + "1 2 3 4");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("10\n" + "3 3 3 3 4 4 4 5 5 5");
		ProblemC.main(null);
		assertResultIs("20");
	}
}
