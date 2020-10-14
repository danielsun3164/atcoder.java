package other.hhkb2020;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("1 5\n" + "..#..", "48");
	}

	@Test
	void case2() {
		check("2 3\n" + "..#\n" + "#..", "52");
	}
}
