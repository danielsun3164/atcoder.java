package abc.abc098;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "2 5 4 6", "5");
	}

	@Test
	void case2() {
		check("9\n" + "0 0 0 0 0 0 0 0 0", "45");
	}

	@Test
	void case3() {
		check("19\n" + "885 8 1 128 83 32 256 206 639 16 4 128 689 32 8 64 885 969 1", "37");
	}
}
