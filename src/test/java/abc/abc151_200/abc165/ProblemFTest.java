package abc.abc151_200.abc165;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("10\n" + "1 2 5 3 4 6 7 3 2 4\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "3 6\n" + "6 7\n" + "1 8\n"
				+ "8 9\n" + "9 10",
				"1" + LF + "2" + LF + "3" + LF + "3" + LF + "4" + LF + "4" + LF + "5" + LF + "2" + LF + "2" + LF + "3");
	}
}
