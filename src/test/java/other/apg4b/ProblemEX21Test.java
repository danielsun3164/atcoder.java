package other.apg4b;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemEX21Test extends TestBase {

	@Test
	void case1() {
		check("1000000 100", "f0: 1" + LF + "f1: 1000100" + LF + "f2: 20000000" + LF + "f3: 9" + LF + "f4: -1" + LF
				+ "f5: -1404227328");
	}

	@Test
	void case2() {
		check("1 1", "f0: 1" + LF + "f1: 2" + LF + "f2: 1" + LF + "f3: 9" + LF + "f4: -1" + LF + "f5: 0");
	}
}
