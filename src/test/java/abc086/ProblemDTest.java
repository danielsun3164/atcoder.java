package abc086;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4 3\n" + "0 1 W\n" + "1 2 W\n" + "5 3 B\n" + "5 4 B");
		ProblemD.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("2 1000\n" + "0 0 B\n" + "0 1 W");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("6 2\n" + "1 2 B\n" + "2 1 W\n" + "2 2 B\n" + "1 0 B\n" + "0 6 W\n" + "4 5 W");
		ProblemD.main(null);
		assertResultIs("4");
	}
}
