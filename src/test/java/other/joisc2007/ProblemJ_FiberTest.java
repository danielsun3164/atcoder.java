package other.joisc2007;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemJ_FiberTest extends TestBase {

	@Test
	void case1() {
		check("8\n" + "7\n" + "3 5\n" + "4 1\n" + "5 4\n" + "7 5\n" + "4 7\n" + "1 4\n" + "6 8", "2");
	}
}
