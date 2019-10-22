package abc064;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4\n" + "2100 2500 2700 2700");
		ProblemC.main(null);
		assertResultIs("2 2");
	}

	@Test
	void test_Case2() {
		in.input("5\n" + "1100 1900 2800 3200 3200");
		ProblemC.main(null);
		assertResultIs("3 5");
	}

	@Test
	void test_Case3() {
		in.input("20\n" + "800 810 820 830 840 850 860 870 880 890 900 910 920 930 940 950 960 970 980 990");
		ProblemC.main(null);
		assertResultIs("1 1");
	}
}
