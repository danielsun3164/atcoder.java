package abc026;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "1\n" + "2\n" + "3");
		ProblemB.main(null);
		assertResultIsAbout(18.8495559215d, 0.000001d);
	}

	@Test
	void test_Case2() {
		in.input("6\n" + "15\n" + "2\n" + "3\n" + "7\n" + "6\n" + "9");
		ProblemB.main(null);
		assertResultIsAbout(508.938009881546d, 0.000001d);
	}
}
