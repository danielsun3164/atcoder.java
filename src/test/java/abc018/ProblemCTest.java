package abc018;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("4 5 2\n" + "xoooo\n" + "oooox\n" + "ooooo\n" + "oxxoo");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("4 5 2\n" + "ooooo\n" + "oxoox\n" + "oooox\n" + "oxxoo");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("8 6 3\n" + "oooooo\n" + "oooooo\n" + "oooooo\n" + "oooooo\n" + "oxoooo\n" + "oooooo\n" + "oooooo\n"
				+ "oooooo");
		ProblemC.main(null);
		assertResultIs("4");
	}
}
