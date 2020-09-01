package abc.abc072;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("atcoder", "acdr");
	}

	@Test
	void case2() {
		check("aaaa", "aa");
	}

	@Test
	void case3() {
		check("z", "z");
	}

	@Test
	void case4() {
		check("fukuokayamaguchi", "fkoaaauh");
	}
}
