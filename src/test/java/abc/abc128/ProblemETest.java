package abc.abc128;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 6\n" + "1 3 2\n" + "7 13 10\n" + "18 20 13\n" + "3 4 2\n" + "0\n" + "1\n" + "2\n" + "3\n" + "5\n"
				+ "8", "2" + LF + "2" + LF + "10" + LF + "-1" + LF + "13" + LF + "-1");
	}
}
