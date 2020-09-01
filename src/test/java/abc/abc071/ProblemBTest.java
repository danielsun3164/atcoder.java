package abc.abc071;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("atcoderregularcontest", "b");
	}

	@Test
	void case2() {
		check("abcdefghijklmnopqrstuvwxyz", "None");
	}

	@Test
	void case3() {
		check("fajsonlslfepbjtsaayxbymeskptcumtwrmkkinjxnnucagfrg", "d");
	}
}
