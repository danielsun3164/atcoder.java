package other.past201912_open;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "10 10 -10 -10 -10\n" + "10 -10 -10 -10\n" + "-10 -10 -10\n" + "10 -10\n" + "-10", "40");
	}

	@Test
	void case2() {
		check("3\n" + "1 1\n" + "1", "3");
	}
}
