package other.hhkb2020;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "..#\n" + "#..", "3");
	}

	@Test
	void case2() {
		check("2 2\n" + ".#\n" + "#.", "0");
	}
}
