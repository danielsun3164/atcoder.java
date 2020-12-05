package other.joi2007ho;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "2\n" + "5\n" + "-4\n" + "10\n" + "3", "11");
	}
}
