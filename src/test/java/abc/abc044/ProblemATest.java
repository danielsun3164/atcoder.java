package abc.abc044;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3\n" + "10000\n" + "9000", "48000");
	}

	@Test
	void case2() {
		check("2\n" + "3\n" + "10000\n" + "9000", "20000");
	}
}
