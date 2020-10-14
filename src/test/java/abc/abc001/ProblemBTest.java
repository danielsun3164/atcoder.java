package abc.abc001;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("15000", "65");
	}

	@Test
	void case2() {
		check("75000", "89");
	}

	@Test
	void case3() {
		check("200", "02");
	}
}
