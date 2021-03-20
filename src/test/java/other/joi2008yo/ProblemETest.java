package other.joi2008yo;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 5\n" + "0 1 0 1 0\n" + "1 0 0 0 1", "9");
	}

	@Test
	void case2() {
		check("3 6\n" + "1 0 0 0 1 0\n" + "1 1 1 0 1 0\n" + "1 0 1 1 0 1", "15");
	}
}
