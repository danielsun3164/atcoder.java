package abc.abc001_050.abc005;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 8", "2");
	}

	@Test
	void case2() {
		check("4 7", "1");
	}

	@Test
	void case3() {
		check("4 3", "0");
	}
}
