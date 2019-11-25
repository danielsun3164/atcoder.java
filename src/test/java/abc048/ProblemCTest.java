package abc048;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3 3\n" + "2 2 2");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("6 1\n" + "1 6 1 2 0 4");
		ProblemC.main(null);
		assertResultIs("11");
	}

	@Test
	void case3() {
		in.input("5 9\n" + "3 1 4 1 5");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("2 0\n" + "5 5");
		ProblemC.main(null);
		assertResultIs("10");
	}
}
