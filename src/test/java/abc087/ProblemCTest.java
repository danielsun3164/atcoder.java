package abc087;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "3 2 2 4 1\n" + "1 2 2 2 1");
		ProblemC.main(null);
		assertResultIs("14");
	}

	@Test
	void case2() {
		in.input("4\n" + "1 1 1 1\n" + "1 1 1 1");
		ProblemC.main(null);
		assertResultIs("5");
	}

	@Test
	void case3() {
		in.input("7\n" + "3 3 4 5 4 5 3\n" + "5 3 4 4 2 3 2");
		ProblemC.main(null);
		assertResultIs("29");
	}

	@Test
	void case4() {
		in.input("1\n" + "2\n" + "3");
		ProblemC.main(null);
		assertResultIs("5");
	}
}
