package abc031;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("6\n" + "1 -3 3 9 1 6");
		ProblemC.main(null);
		assertResultIs("6");
	}

	@Test
	void test_Case2() {
		in.input("3\n" + "5 5 5");
		ProblemC.main(null);
		assertResultIs("10");
	}

	@Test
	void test_Case3() {
		in.input("8\n" + "-1 10 -1 2 -1 10 -1 0");
		ProblemC.main(null);
		assertResultIs("-1");
	}
}
