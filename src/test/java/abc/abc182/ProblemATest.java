package abc.abc182;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("200 300", "200");
	}

	@Test
	void case2() {
		check("10000 0", "20100");
	}
}
