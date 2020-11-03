package abc.abc025;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("abcde\n" + "8", "bc");
	}

	@Test
	void case2() {
		check("aeiou\n" + "22", "ue");
	}

	@Test
	void case3() {
		check("vwxyz\n" + "25", "zz");
	}
}
