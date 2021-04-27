package abc.abc151_200.abc198;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("a\n" + "b\n" + "c", "1" + LF + "2" + LF + "3");
	}

	@Test
	void case2() {
		check("x\n" + "x\n" + "y", "1" + LF + "1" + LF + "2");
	}

	@Test
	void case3() {
		check("p\n" + "q\n" + "p", "UNSOLVABLE");
	}

	@Test
	void case4() {
		check("abcd\n" + "efgh\n" + "ijkl", "UNSOLVABLE");
	}

	@Test
	void case5() {
		check("send\n" + "more\n" + "money", "9567" + LF + "1085" + LF + "10652");
	}
}
