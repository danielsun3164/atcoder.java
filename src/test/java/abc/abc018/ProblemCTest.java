package abc.abc018;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 5 2\n" + "xoooo\n" + "oooox\n" + "ooooo\n" + "oxxoo", "3");
	}

	@Test
	void case2() {
		check("4 5 2\n" + "ooooo\n" + "oxoox\n" + "oooox\n" + "oxxoo", "0");
	}

	@Test
	void case3() {
		check("8 6 3\n" + "oooooo\n" + "oooooo\n" + "oooooo\n" + "oooooo\n" + "oxoooo\n" + "oooooo\n" + "oooooo\n"
				+ "oooooo", "4");
	}
}
