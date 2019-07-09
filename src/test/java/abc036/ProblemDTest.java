package abc036;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5\n" + "2 5\n" + "1 5\n" + "2 4\n" + "3 2");
		ProblemD.main(null);
		assertResultIs("14");
	}

	@Test
	void test_Case2() {
		in.input("10\n" + "7 9\n" + "8 1\n" + "9 6\n" + "10 8\n" + "8 6\n" + "10 3\n" + "5 8\n" + "4 8\n" + "2 5");
		ProblemD.main(null);
		assertResultIs("192");
	}
}
