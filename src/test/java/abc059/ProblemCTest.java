package abc059;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4\n" + "1 -3 1 0");
		ProblemC.main(null);
		assertResultIs("4");
	}

	@Test
	void test_Case2() {
		in.input("5\n" + "3 -6 4 -5 7");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("6\n" + "-1 4 3 2 -5 4");
		ProblemC.main(null);
		assertResultIs("8");
	}
}
