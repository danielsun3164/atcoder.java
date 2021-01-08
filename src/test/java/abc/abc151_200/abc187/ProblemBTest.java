package abc.abc151_200.abc187;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "0 0\n" + "1 2\n" + "2 1", "2");
	}

	@Test
	void case2() {
		check("1\n" + "-691 273", "0");
	}

	@Test
	void case3() {
		check("10\n" + "-31 -35\n" + "8 -36\n" + "22 64\n" + "5 73\n" + "-14 8\n" + "18 -58\n" + "-41 -85\n" + "1 -88\n"
				+ "-21 -85\n" + "-11 82", "11");
	}
}
