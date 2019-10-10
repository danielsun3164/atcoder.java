package abc060;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 4\n" + "0 3");
		ProblemC.main(null);
		assertResultIs("7");
	}

	@Test
	void test_Case2() {
		in.input("2 4\n" + "0 5");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void test_Case3() {
		in.input("4 1000000000\n" + "0 1000 1000000 1000000000");
		ProblemC.main(null);
		assertResultIs("2000000000");
	}

	@Test
	void test_Case4() {
		in.input("1 1\n" + "0");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case5() {
		in.input("9 10\n" + "0 3 5 7 100 110 200 300 311");
		ProblemC.main(null);
		assertResultIs("67");
	}
}
