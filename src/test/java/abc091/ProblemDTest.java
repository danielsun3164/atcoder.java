package abc091;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("2\n" + "1 2\n" + "3 4");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("6\n" + "4 6 0 0 3 3\n" + "0 5 6 5 0 3");
		ProblemD.main(null);
		assertResultIs("8");
	}

	@Test
	void case3() {
		in.input("5\n" + "1 2 3 4 5\n" + "1 2 3 4 5");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case4() {
		in.input("1\n" + "0\n" + "0");
		ProblemD.main(null);
		assertResultIs("0");
	}
}
