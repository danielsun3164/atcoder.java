package abc077;

import org.junit.jupiter.api.Test;

import practice.TestBase;

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
