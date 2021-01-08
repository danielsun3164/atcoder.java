package abc.abc101_150.abc104;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("AtCoder", "AC");
	}

	@Test
	void case2() {
		check("ACoder", "WA");
	}

	@Test
	void case3() {
		check("AcycliC", "WA");
	}

	@Test
	void case4() {
		check("AtCoCo", "WA");
	}

	@Test
	void case5() {
		check("Atcoder", "WA");
	}
}
