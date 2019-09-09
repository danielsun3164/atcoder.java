package abc041;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 2\n" + "2 1\n" + "2 3");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("5 5\n" + "1 2\n" + "2 3\n" + "3 5\n" + "1 4\n" + "4 5");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case3() {
		in.input("16 1\n" + "1 2");
		ProblemD.main(null);
		assertResultIs("10461394944000");
	}
}
