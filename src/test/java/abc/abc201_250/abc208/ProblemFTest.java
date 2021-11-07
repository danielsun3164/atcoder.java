package abc.abc201_250.abc208;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 4 2", "35");
	}

	@Test
	void case2() {
		check("0 1 2", "0");
	}

	@Test
	void case3() {
		check("1000000000000000000 30 123456", "297085514");
	}
}
