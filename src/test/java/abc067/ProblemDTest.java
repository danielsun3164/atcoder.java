package abc067;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("7\n" + "3 6\n" + "1 2\n" + "3 1\n" + "7 4\n" + "5 7\n" + "1 4");
		ProblemD.main(null);
		assertResultIs("Fennec");
	}

	@Test
	void test_Case2() {
		in.input("4\n" + "1 4\n" + "4 2\n" + "2 3");
		ProblemD.main(null);
		assertResultIs("Snuke");
	}
}
