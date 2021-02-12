package other.joisc2007;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemC_MallTest extends TestBase {

	@Test
	void case1() {
		check("7 6\n" + "3 2\n" + "26 29 84 15 -1 1 71\n" + "45 14 38 91 62 77 35\n" + "68 -1 -1 90 63 56 70\n"
				+ "31 2 4 74 72 41 90\n" + "100 26 21 -1 44 72 60\n" + "71 4 40 93 48 -1 50", "184");
	}
}
