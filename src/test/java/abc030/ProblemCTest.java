package abc030;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 4\n" + "2 3\n" + "1 5 7\n" + "3 8 12 13");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("1 1\n" + "1 1\n" + "1\n" + "1");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("6 7\n" + "5 3\n" + "1 7 12 19 20 26\n" + "4 9 15 23 24 31 33");
		ProblemC.main(null);
		assertResultIs("3");
	}
}
