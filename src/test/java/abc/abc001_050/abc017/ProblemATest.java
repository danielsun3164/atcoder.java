package abc.abc001_050.abc017;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("50 7\n" + "40 8\n" + "30 9", "94");
	}

	@Test
	void case2() {
		check("990 10\n" + "990 10\n" + "990 10", "2970");
	}
}
