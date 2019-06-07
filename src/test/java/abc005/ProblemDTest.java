package abc005;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "3 2 1\n" + "2 2 1\n" + "1 1 1\n" + "3\n" + "1\n" + "4\n" + "9");
		ProblemD.main(null);
		assertResultIs("3\n" + "9\n" + "14");
	}

	@Test
	void test_Case2() {
		in.input("3\n" + "1 1 1\n" + "1 1 1\n" + "9 9 9\n" + "1\n" + "4");
		ProblemD.main(null);
		assertResultIs("27");
	}
}
