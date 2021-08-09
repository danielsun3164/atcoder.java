package abc.abc101_150.abc150;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10\n" + "ZABCDBABCQ", "2");
	}

	@Test
	void case2() {
		check("19\n" + "THREEONEFOURONEFIVE", "0");
	}

	@Test
	void case3() {
		check("33\n" + "ABCCABCBABCCABACBCBBABCBCBCBCABCB", "5");
	}
}
