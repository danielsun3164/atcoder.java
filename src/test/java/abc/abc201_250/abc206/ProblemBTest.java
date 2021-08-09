package abc.abc201_250.abc206;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("12", "5");
	}

	@Test
	void case2() {
		check("100128", "447");
	}

	@Test
	void case3() {
		check("1000000000", "44721");
	}
}
