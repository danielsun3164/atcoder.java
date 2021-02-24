package abc.abc101_150.abc137;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "acornistnt\n" + "peanutbomb\n" + "constraint", "1");
	}

	@Test
	void case2() {
		check("2\n" + "oneplustwo\n" + "ninemodsix", "0");
	}

	@Test
	void case3() {
		check("5\n" + "abaaaaaaaa\n" + "oneplustwo\n" + "aaaaaaaaba\n" + "twoplusone\n" + "aaaabaaaaa", "4");
	}
}
