package abc.abc201_250.abc215;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 2", "1" + LF + "665496237" + LF + "2");
	}

	@Test
	void case2() {
		check("11\n" + "3 1 4 1 5 9 2 6 5 3 5",
				"1" + LF + "725995895" + LF + "532396991" + LF + "768345657" + LF + "786495555" + LF + "937744700" + LF
						+ "574746754" + LF + "48399732" + LF + "707846002" + LF + "907494873" + LF + "7");
	}
}
