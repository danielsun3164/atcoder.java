package abc.abc001_050.abc049;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("a", "vowel");
	}

	@Test
	void case2() {
		check("z", "consonant");
	}

	@Test
	void case3() {
		check("s", "consonant");
	}
}
