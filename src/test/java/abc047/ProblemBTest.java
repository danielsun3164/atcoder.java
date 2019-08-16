package abc047;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5 4 2\n" + "2 1 1\n" + "3 3 4");
		ProblemB.main(null);
		assertResultIs("9");
	}

	@Test
	void test_Case2() {
		in.input("5 4 3\n" + "2 1 1\n" + "3 3 4\n" + "1 4 2");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("10 10 5\n" + "1 6 1\n" + "4 1 3\n" + "6 9 4\n" + "9 4 2\n" + "3 1 3");
		ProblemB.main(null);
		assertResultIs("64");
	}
}
