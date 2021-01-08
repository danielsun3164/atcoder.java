package abc.abc151_200.abc173;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 3\n" + "2 3", "7");
	}

	@Test
	void case2() {
		check("2\n" + "1 2", "3");
	}

	@Test
	void case3() {
		check("10\n" + "5 3\n" + "5 7\n" + "8 9\n" + "1 9\n" + "9 10\n" + "8 4\n" + "7 4\n" + "6 10\n" + "7 2", "113");
	}
}
