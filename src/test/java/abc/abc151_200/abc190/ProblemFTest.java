package abc.abc151_200.abc190;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "0 1 2 3", "0" + LF + "3" + LF + "4" + LF + "3");
	}

	@Test
	void case2() {
		check("10\n" + "0 3 1 5 4 2 9 6 8 7", "9" + LF + "18" + LF + "21" + LF + "28" + LF + "27" + LF + "28" + LF
				+ "33" + LF + "24" + LF + "21" + LF + "14");
	}
}
