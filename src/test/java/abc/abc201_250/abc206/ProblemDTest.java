package abc.abc201_250.abc206;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("8\n" + "1 5 3 2 5 2 3 1", "2");
	}

	@Test
	void case2() {
		check("7\n" + "1 2 3 4 1 2 3", "1");
	}

	@Test
	void case3() {
		check("1\n" + "200000", "0");
	}
}
