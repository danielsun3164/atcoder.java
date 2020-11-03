package other.apg4b;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemEX20Test extends TestBase {

	@Test
	void case1() {
		check("6\n" + "0 0 1 1 4", "6" + LF + "4" + LF + "1" + LF + "1" + LF + "2" + LF + "1");
	}

	@Test
	void case2() {
		check("8\n" + "0 0 1 2 0 3 6",
				"8" + LF + "4" + LF + "2" + LF + "3" + LF + "1" + LF + "1" + LF + "2" + LF + "1");
	}
}
