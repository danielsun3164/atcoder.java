package abc.abc151_200.abc159;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "2 2 4", "5");
	}

	@Test
	void case2() {
		check("5 8\n" + "9 9 9 9 9", "0");
	}

	@Test
	void case3() {
		check("10 10\n" + "3 1 4 1 5 9 2 6 5 3", "152");
	}
}
