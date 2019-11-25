package abc058;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("xyz\n" + "abc");
		ProblemB.main(null);
		assertResultIs("xaybzc");
	}

	@Test
	void case2() {
		in.input("atcoderbeginnercontest\n" + "atcoderregularcontest");
		ProblemB.main(null);
		assertResultIs("aattccooddeerrbreeggiunlnaerrccoonntteesstt");
	}
}
