package abc.abc082;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("yx\n" + "axy", "Yes");
	}

	@Test
	void case2() {
		check("ratcode\n" + "atlas", "Yes");
	}

	@Test
	void case3() {
		check("cd\n" + "abc", "No");
	}

	@Test
	void case4() {
		check("w\n" + "ww", "Yes");
	}

	@Test
	void case5() {
		check("zzz\n" + "zzz", "No");
	}
}
