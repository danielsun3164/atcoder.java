package abc.abc201_250.abc206;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 7", "2");
	}

	@Test
	void case2() {
		check("4 10", "12");
	}

	@Test
	void case3() {
		check("1 1000000", "392047955148");
	}

	@Test
	void case4() {
		check("1 100", "3248");
	}
}
