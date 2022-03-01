package abc.abc151_200.abc163;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 2", "10");
	}

	@Test
	void case2() {
		check("200000 200001", "1");
	}

	@Test
	void case3() {
		check("141421 35623", "220280457");
	}
}
