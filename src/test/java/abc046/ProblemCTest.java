package abc046;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "2 3\n" + "1 1\n" + "3 2");
		ProblemC.main(null);
		assertResultIs("10");
	}

	@Test
	void case2() {
		in.input("4\n" + "1 1\n" + "1 1\n" + "1 5\n" + "1 100");
		ProblemC.main(null);
		assertResultIs("101");
	}

	@Test
	void case3() {
		in.input("5\n" + "3 10\n" + "48 17\n" + "31 199\n" + "231 23\n" + "3 2");
		ProblemC.main(null);
		assertResultIs("6930");
	}
}
