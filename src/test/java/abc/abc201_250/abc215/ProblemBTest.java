package abc.abc201_250.abc215;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6", "2");
	}

	@Test
	void case2() {
		check("1", "0");
	}

	@Test
	void case3() {
		check("1000000000000000000", "59");
	}
}
