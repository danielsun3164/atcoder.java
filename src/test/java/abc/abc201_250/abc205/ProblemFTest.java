package abc.abc201_250.abc205;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2 3 3\n" + "1 1 2 2\n" + "1 2 2 3\n" + "1 1 1 3", "2");
	}

	@Test
	void case2() {
		check("5 5 3\n" + "1 1 5 5\n" + "1 1 4 4\n" + "2 2 3 3", "3");
	}
}
