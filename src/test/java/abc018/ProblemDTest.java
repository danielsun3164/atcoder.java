package abc018;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 4 2 3 7\n" + "1 1 9\n" + "1 2 7\n" + "1 3 15\n" + "1 4 6\n" + "2 2 3\n" + "2 4 6\n" + "3 3 6");
		ProblemD.main(null);
		assertResultIs("37");
	}

	@Test
	void test_Case2() {
		in.input("4 5 3 2 9\n" + "2 3 5\n" + "3 1 4\n" + "2 2 2\n" + "4 1 9\n" + "3 5 3\n" + "3 3 8\n" + "1 4 5\n"
				+ "1 5 7\n" + "2 4 8");
		ProblemD.main(null);
		assertResultIs("26");
	}
}
