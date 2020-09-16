package abc.abc119;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 3 4\n" + "100\n" + "600\n" + "400\n" + "900\n" + "1000\n" + "150\n" + "2000\n" + "899\n" + "799",
				"350" + LF + "1400" + LF + "301" + LF + "399");
	}

	@Test
	void case2() {
		check("1 1 3\n" + "1\n" + "10000000000\n" + "2\n" + "9999999999\n" + "5000000000",
				"10000000000" + LF + "10000000000" + LF + "14999999998");
	}
}
