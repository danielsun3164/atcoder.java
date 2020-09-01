package abc.abc176;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "1 1\n" + "4 4\n" + "..#.\n" + "..#.\n" + ".#..\n" + ".#..", "1");
	}

	@Test
	void case2() {
		check("4 4\n" + "1 4\n" + "4 1\n" + ".##.\n" + "####\n" + "####\n" + ".##.", "-1");
	}

	@Test
	void case3() {
		check("4 4\n" + "2 2\n" + "3 3\n" + "....\n" + "....\n" + "....\n" + "....", "0");
	}

	@Test
	void case4() {
		check("4 5\n" + "1 2\n" + "2 5\n" + "#.###\n" + "####.\n" + "#..##\n" + "#..##", "2");
	}
}
