package abc.abc201_250.abc210;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 3 20 15", "90");
	}

	@Test
	void case2() {
		check("10 10 100 1", "1000");
	}
}
