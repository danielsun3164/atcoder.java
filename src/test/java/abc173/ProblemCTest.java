package abc173;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2 3 2\n" + "..#\n" + "###");
		ProblemC.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("2 3 4\n" + "..#\n" + "###");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("2 2 3\n" + "##\n" + "##");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("6 6 8\n" + "..##..\n" + ".#..#.\n" + "#....#\n" + "######\n" + "#....#\n" + "#....#");
		ProblemC.main(null);
		assertResultIs("208");
	}
}
