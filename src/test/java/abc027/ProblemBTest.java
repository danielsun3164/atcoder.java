package abc027;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "1 2 3");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("5\n" + "2 0 0 0 3");
		ProblemB.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case3() {
		in.input("2\n" + "0 99");
		ProblemB.main(null);
		assertResultIs("-1");
	}

	@Test
	void test_Case4() {
		in.input("4\n" + "0 0 0 0");
		ProblemB.main(null);
		assertResultIs("0");
	}
}
