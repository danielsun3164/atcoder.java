package abc017;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5 2\n" + "1\n" + "2\n" + "1\n" + "2\n" + "2");
		ProblemD.main(null);
		assertResultIs("5");
	}

	@Test
	void test_Case2() {
		in.input("6 6\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6");
		ProblemD.main(null);
		assertResultIs("32");
	}
}
