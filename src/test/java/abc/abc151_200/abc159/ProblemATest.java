package abc.abc151_200.abc159;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 1", "1");
	}

	@Test
	void case2() {
		check("4 3", "9");
	}

	@Test
	void case3() {
		check("1 1", "0");
	}

	@Test
	void case4() {
		check("13 3", "81");
	}

	@Test
	void case5() {
		check("0 3", "3");
	}
}
