package abc173;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 3 2\n" + "..#\n" + "###", "5");
	}

	@Test
	void case2() {
		check("2 3 4\n" + "..#\n" + "###", "1");
	}

	@Test
	void case3() {
		check("2 2 3\n" + "##\n" + "##", "0");
	}

	@Test
	void case4() {
		check("6 6 8\n" + "..##..\n" + ".#..#.\n" + "#....#\n" + "######\n" + "#....#\n" + "#....#", "208");
	}
}
