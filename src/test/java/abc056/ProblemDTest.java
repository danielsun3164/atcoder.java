package abc056;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3 6\n" + "1 4 3");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("5 400\n" + "3 1 4 1 5");
		ProblemD.main(null);
		assertResultIs("5");
	}

	@Test
	void case3() {
		in.input("6 20\n" + "10 4 3 10 25 2");
		ProblemD.main(null);
		assertResultIs("3");
	}
}
