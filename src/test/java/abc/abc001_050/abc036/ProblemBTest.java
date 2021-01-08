package abc.abc001_050.abc036;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "ooxx\n" + "xoox\n" + "xxxx\n" + "xxxx", "xxxo" + LF + "xxoo" + LF + "xxox" + LF + "xxxx");
	}

	@Test
	void case2() {
		check("4\n" + "ooxx\n" + "xxxx\n" + "xxxx\n" + "xxxx", "xxxo" + LF + "xxxo" + LF + "xxxx" + LF + "xxxx");
	}
}
