package abc.abc020;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 3 10\n" + "S##\n" + ".#G", "8");
	}

	@Test
	void case2() {
		check("3 4 7\n" + "S##G\n" + ".##.\n" + "..#.", "3");
	}

	@Test
	void case3() {
		check("4 4 1000000000\n" + "S###\n" + "####\n" + "####\n" + "###G", "199999999");
	}
}
