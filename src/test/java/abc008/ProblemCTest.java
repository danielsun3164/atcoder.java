package abc008;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "2\n" + "4\n" + "8");
		ProblemC.main(null);
		assertResultIsAbout(2.166666666667d, 0.000001d);
	}

	@Test
	void test_Case2() {
		in.input("4\n" + "5\n" + "5\n" + "5\n" + "5");
		ProblemC.main(null);
		assertResultIs(2.0d);
	}

	@Test
	void test_Case3() {
		in.input("5\n" + "2\n" + "3\n" + "2\n" + "6\n" + "12");
		ProblemC.main(null);
		assertResultIs(3.1d);
	}
}
