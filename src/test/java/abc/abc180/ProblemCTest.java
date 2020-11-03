package abc.abc180;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6", "1" + LF + "2" + LF + "3" + LF + "6");
	}

	@Test
	void case2() {
		check("720",
				"1" + LF + "2" + LF + "3" + LF + "4" + LF + "5" + LF + "6" + LF + "8" + LF + "9" + LF + "10" + LF + "12"
						+ LF + "15" + LF + "16" + LF + "18" + LF + "20" + LF + "24" + LF + "30" + LF + "36" + LF + "40"
						+ LF + "45" + LF + "48" + LF + "60" + LF + "72" + LF + "80" + LF + "90" + LF + "120" + LF
						+ "144" + LF + "180" + LF + "240" + LF + "360" + LF + "720");
	}

	@Test
	void case3() {
		check("1000000007", "1" + LF + "1000000007");
	}
}
