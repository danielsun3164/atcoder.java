package other.joi2007yo;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 2 2\n" + "4\n" + "2 4 5 0\n" + "2 3 6 0\n" + "1 4 5 0\n" + "2 3 5 1",
				"2" + LF + "1" + LF + "1" + LF + "0" + LF + "1" + LF + "0");
	}
}
