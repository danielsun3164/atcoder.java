package abc.abc201_250.abc207;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 2 3 2", "2");
	}

	@Test
	void case2() {
		check("6 9 2 3", "-1");
	}
}
