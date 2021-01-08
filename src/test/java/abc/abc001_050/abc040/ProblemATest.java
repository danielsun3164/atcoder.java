package abc.abc001_050.abc040;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 2", "1");
	}

	@Test
	void case2() {
		check("6 4", "2");
	}

	@Test
	void case3() {
		check("90 30", "29");
	}
}
