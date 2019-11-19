package abc071;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("atcoderregularcontest");
		ProblemB.main(null);
		assertResultIs("b");
	}

	@Test
	void test_Case2() {
		in.input("abcdefghijklmnopqrstuvwxyz");
		ProblemB.main(null);
		assertResultIs("None");
	}

	@Test
	void test_Case3() {
		in.input("fajsonlslfepbjtsaayxbymeskptcumtwrmkkinjxnnucagfrg");
		ProblemB.main(null);
		assertResultIs("d");
	}
}
