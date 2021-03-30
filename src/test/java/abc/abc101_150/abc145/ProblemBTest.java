package abc.abc101_150.abc145;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "abcabc", "Yes");
	}

	@Test
	void case2() {
		check("6\n" + "abcadc	", "No");
	}

	@Test
	void case3() {
		check("1\n" + "z", "No");
	}
}
