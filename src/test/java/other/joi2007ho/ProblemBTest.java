package other.joi2007ho;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("7 5\n" + "6\n" + "2\n" + "4\n" + "7\n" + "1", "2");
	}

	@Test
	void case2() {
		check("7 5\n" + "6\n" + "2\n" + "4\n" + "7\n" + "0", "4");
	}
}
