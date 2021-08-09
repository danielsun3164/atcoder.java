package abc.abc201_250.abc204;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "6 17 28", "25");
	}

	@Test
	void case2() {
		check("4\n" + "8 9 10 11", "1");
	}
}
