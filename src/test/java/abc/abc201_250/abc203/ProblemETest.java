package abc.abc201_250.abc203;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 4\n" + "1 1\n" + "1 2\n" + "2 0\n" + "4 2", "3");
	}

	@Test
	void case2() {
		check("1 1\n" + "1 1", "0");
	}
}
