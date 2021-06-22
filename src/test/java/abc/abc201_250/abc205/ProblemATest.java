package abc.abc201_250.abc205;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("45 200", 90.0d);
	}

	@Test
	void case2() {
		check("37 450", 166.5d);
	}

	@Test
	void case3() {
		check("0 1000", 0.0d);
	}

	@Test
	void case4() {
		check("50 0", 0.0d);
	}
}
