package abc.abc051_100.abc077;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("pot\n" + "top", "YES");
	}

	@Test
	void case2() {
		check("tab\n" + "bet", "NO");
	}

	@Test
	void case3() {
		check("eye\n" + "eel", "NO");
	}
}
