package other.joisc2007;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemA_ScoreTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "100\n" + "90\n" + "80\n" + "90\n" + "100\n" + "65",
				"1" + LF + "3" + LF + "5" + LF + "3" + LF + "1" + LF + "6");
	}
}
