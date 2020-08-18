package abc175;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "4 4 9 7 5");
		ProblemB.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("6\n" + "4 5 4 3 3 5");
		ProblemB.main(null);
		assertResultIs("8");
	}

	@Test
	void case3() {
		in.input("10\n" + "9 4 6 1 9 6 10 6 6 8");
		ProblemB.main(null);
		assertResultIs("39");
	}

	@Test
	void case4() {
		in.input("2\n" + "1 1");
		ProblemB.main(null);
		assertResultIs("0");
	}
}
