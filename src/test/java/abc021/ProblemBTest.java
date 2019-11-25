package abc021;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "1 5\n" + "3\n" + "3 4 2");
		ProblemB.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("7\n" + "1 3\n" + "4\n" + "2 4 2 7");
		ProblemB.main(null);
		assertResultIs("NO");
	}

	@Test
	void case3() {
		in.input("4\n" + "1 4\n" + "3\n" + "2 1 3");
		ProblemB.main(null);
		assertResultIs("NO");
	}

	@Test
	void case4() {
		in.input("4\n" + "1 4\n" + "3\n" + "2 4 3");
		ProblemB.main(null);
		assertResultIs("NO");
	}

	@Test
	void case5() {
		in.input("20\n" + "1 4\n" + "12\n" + "2 3 5 7 8 9 10 11 12 15 13 14");
		ProblemB.main(null);
		assertResultIs("YES");
	}
}
