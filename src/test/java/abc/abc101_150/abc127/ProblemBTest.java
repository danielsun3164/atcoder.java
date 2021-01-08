package abc.abc101_150.abc127;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 10 20", "30" + LF + "50" + LF + "90" + LF + "170" + LF + "330" + LF + "650" + LF + "1290" + LF + "2570"
				+ LF + "5130" + LF + "10250");
	}

	@Test
	void case2() {
		check("4 40 60", "200" + LF + "760" + LF + "3000" + LF + "11960" + LF + "47800" + LF + "191160" + LF + "764600"
				+ LF + "3058360" + LF + "12233400" + LF + "48933560");
	}
}
