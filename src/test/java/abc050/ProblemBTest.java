package abc050;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "2 1 4\n" + "2\n" + "1 1\n" + "2 3");
		ProblemB.main(null);
		assertResultIs("6" + LF + "9");
	}

	@Test
	void test_Case2() {
		in.input("5\n" + "7 2 3 8 5\n" + "3\n" + "4 2\n" + "1 7\n" + "4 13");
		ProblemB.main(null);
		assertResultIs("19" + LF + "25" + LF + "30");
	}
}
