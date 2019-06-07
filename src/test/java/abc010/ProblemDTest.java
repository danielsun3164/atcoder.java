package abc010;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4 2 3\n" + "2 3\n" + "0 1\n" + "1 2\n" + "1 3");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case2() {
		in.input("4 1 4\n" + "3\n" + "0 1\n" + "0 2\n" + "1 3\n" + "2 3");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case3() {
		in.input("10 3 11\n" + "7 8 9\n" + "0 1\n" + "0 2\n" + "0 3\n" + "0 4\n" + "1 5\n" + "2 5\n" + "5 6\n" + "6 7\n"
				+ "6 8\n" + "3 9\n" + "4 9");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case4() {
		in.input("6 2 6\n" + "4 5\n" + "0 1\n" + "0 2\n" + "1 3\n" + "2 3\n" + "3 4\n" + "3 5");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case5() {
		in.input("4 3 3\n" + "1 2 3\n" + "1 2\n" + "1 3\n" + "2 3");
		ProblemD.main(null);
		assertResultIs("0");
	}
}
