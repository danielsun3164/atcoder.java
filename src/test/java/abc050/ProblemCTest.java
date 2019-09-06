package abc050;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5\n" + "2 4 4 0 2");
		ProblemC.main(null);
		assertResultIs("4");
	}

	@Test
	void test_Case2() {
		in.input("7\n" + "6 4 0 2 4 0 2");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("8\n" + "7 5 1 1 7 3 5 3");
		ProblemC.main(null);
		assertResultIs("16");
	}
}
