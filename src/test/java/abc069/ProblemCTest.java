package abc069;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "1 10 100");
		ProblemC.main(null);
		assertResultIs("Yes");
	}

	@Test
	void test_Case2() {
		in.input("4\n" + "1 2 3 4");
		ProblemC.main(null);
		assertResultIs("No");
	}

	@Test
	void test_Case3() {
		in.input("3\n" + "1 4 1");
		ProblemC.main(null);
		assertResultIs("Yes");
	}

	@Test
	void test_Case4() {
		in.input("2\n" + "1 1");
		ProblemC.main(null);
		assertResultIs("No");
	}

	@Test
	void test_Case5() {
		in.input("6\n" + "2 7 1 8 2 8");
		ProblemC.main(null);
		assertResultIs("Yes");
	}
}
