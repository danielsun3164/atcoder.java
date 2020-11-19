package other.abl;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("10 3\n" + "1\n" + "5\n" + "4\n" + "3\n" + "8\n" + "6\n" + "9\n" + "7\n" + "2\n" + "4", "7");
	}
}
