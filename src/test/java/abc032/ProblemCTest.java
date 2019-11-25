package abc032;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("7 6\n" + "4\n" + "3\n" + "1\n" + "1\n" + "2\n" + "10\n" + "2");
		ProblemC.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("6 10\n" + "10\n" + "10\n" + "10\n" + "10\n" + "0\n" + "10");
		ProblemC.main(null);
		assertResultIs("6");
	}

	@Test
	void case3() {
		in.input("6 9\n" + "10\n" + "10\n" + "10\n" + "10\n" + "10\n" + "10");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("4 0\n" + "1\n" + "2\n" + "3\n" + "4");
		ProblemC.main(null);
		assertResultIs("0");
	}
}
