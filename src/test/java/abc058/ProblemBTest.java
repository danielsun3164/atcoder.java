package abc058;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("xyz\n" + "abc");
		ProblemB.main(null);
		assertResultIs("xaybzc");
	}

	@Test
	void test_Case2() {
		in.input("atcoderbeginnercontest\n" + "atcoderregularcontest");
		ProblemB.main(null);
		assertResultIs("aattccooddeerrbreeggiunlnaerrccoonntteesstt");
	}
}
