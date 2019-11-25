package abc020;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2 3 10\n" + "S##\n" + ".#G");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void case2() {
		in.input("3 4 7\n" + "S##G\n" + ".##.\n" + "..#.");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case3() {
		in.input("4 4 1000000000\n" + "S###\n" + "####\n" + "####\n" + "###G");
		ProblemC.main(null);
		assertResultIs("199999999");
	}
}
