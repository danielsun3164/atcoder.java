package abc.abc001_050.abc031;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("300 400\n" + "3\n" + "240\n" + "350\n" + "480", "60" + LF + "0" + LF + "-1");
	}

	@Test
	void case2() {
		check("50 80\n" + "5\n" + "10000\n" + "50\n" + "81\n" + "80\n" + "0",
				"-1" + LF + "0" + LF + "-1" + LF + "0" + LF + "50");
	}
}
