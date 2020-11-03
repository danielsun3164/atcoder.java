package abc.abc064;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "2100 2500 2700 2700", "2 2");
	}

	@Test
	void case2() {
		check("5\n" + "1100 1900 2800 3200 3200", "3 5");
	}

	@Test
	void case3() {
		check("20\n" + "800 810 820 830 840 850 860 870 880 890 900 910 920 930 940 950 960 970 980 990", "1 1");
	}
}
