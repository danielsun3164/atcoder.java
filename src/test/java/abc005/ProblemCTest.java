package abc005;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("1\n" + "3\n" + "1 2 3\n" + "3\n" + "2 3 4");
		ProblemC.main(null);
		assertResultIs("yes");
	}

	@Test
	void case2() {
		in.input("1\n" + "3\n" + "1 2 3\n" + "3\n" + "2 3 5");
		ProblemC.main(null);
		assertResultIs("no");
	}

	@Test
	void case3() {
		in.input("1\n" + "3\n" + "1 2 3\n" + "10\n" + "1 2 3 4 5 6 7 8 9 10");
		ProblemC.main(null);
		assertResultIs("no");
	}

	@Test
	void case4() {
		in.input("1\n" + "3\n" + "1 2 3\n" + "3\n" + "1 2 2");
		ProblemC.main(null);
		assertResultIs("no");
	}

	@Test
	void case5() {
		in.input("2\n" + "5\n" + "1 3 6 10 15\n" + "3\n" + "4 8 16");
		ProblemC.main(null);
		assertResultIs("yes");
	}
}
