package abc.abc151_200.abc155;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("36", "8");
	}

	@Test
	void case2() {
		check("91", "3");
	}

	@Test
	void case3() {
		check("314159265358979323846264338327950288419716939937551058209749445923078164062862089986280348253421170",
				"243");
	}
}
