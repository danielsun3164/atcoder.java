package abc066;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("abaababaab", "6");
	}

	@Test
	void case2() {
		check("xxxx", "2");
	}

	@Test
	void case3() {
		check("abcabcabcabc", "6");
	}

	@Test
	void case4() {
		check("akasakaakasakasakaakas", "14");
	}
}
