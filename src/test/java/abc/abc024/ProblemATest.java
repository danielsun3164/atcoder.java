package abc.abc024;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("100 200 50 20\n" + "40 10", "3500");
	}

	@Test
	void case2() {
		check("400 1000 400 21\n" + "10 10", "14000");
	}

	@Test
	void case3() {
		check("400 1000 400 20\n" + "10 10", "6000");
	}
}
