package abc.abc151_200.abc178;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 1\n" + "2 4\n" + "3 2", "4");
	}

	@Test
	void case2() {
		check("2\n" + "1 1\n" + "1 1", "0");
	}
}
