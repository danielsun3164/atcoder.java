package other.loadchecking;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("",
				"2" + LF + "20" + LF + "19" + LF + "10" + LF + "17" + LF + "12" + LF + "9" + LF + "13" + LF + "14" + LF
						+ "15" + LF + "4" + LF + "8" + LF + "3" + LF + "16" + LF + "11" + LF + "18" + LF + "7" + LF
						+ "5" + LF + "1" + LF + "6");
	}
}
