package abc.abc151_200.abc191;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "6 9 12", "2");
	}

	@Test
	void case2() {
		check("4\n" + "8 2 12 6", "1");
	}

	@Test
	void case3() {
		check("7\n" + "30 28 33 49 27 37 48", "7");
	}

	@Test
	void case4() {
		check("4\n" + "80 15 30 6", "5");
	}
}
