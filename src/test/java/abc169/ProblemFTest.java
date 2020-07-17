package abc169;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		in.input("3 4\n" + "2 2 4");
		ProblemF.main(null);
		assertResultIs("6");
	}

	@Test
	void case2() {
		in.input("5 8\n" + "9 9 9 9 9");
		ProblemF.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("10 10\n" + "3 1 4 1 5 9 2 6 5 3");
		ProblemF.main(null);
		assertResultIs("3296");
	}
}
