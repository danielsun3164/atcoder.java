package abc.abc151_200.abc154;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("1 1 2 2", "14");
	}

	@Test
	void case2() {
		check("314 159 2653 589", "602215194");
	}
}
