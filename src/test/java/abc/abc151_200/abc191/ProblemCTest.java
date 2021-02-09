package abc.abc151_200.abc191;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + ".....\n" + ".###.\n" + ".###.\n" + ".###.\n" + ".....", "4");
	}

	@Test
	void case2() {
		check("5 5\n" + ".....\n" + ".###.\n" + ".###.\n" + "..#..\n" + ".....", "8");
	}
}
