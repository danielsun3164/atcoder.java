package abc.abc151_200.abc153;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 3 2\n" + "1 2\n" + "5 4\n" + "9 2", "2");
	}

	@Test
	void case2() {
		check("9 4 1\n" + "1 5\n" + "2 4\n" + "3 3\n" + "4 2\n" + "5 1\n" + "6 2\n" + "7 3\n" + "8 4\n" + "9 5", "5");
	}

	@Test
	void case3() {
		check("3 0 1\n" + "300000000 1000000000\n" + "100000000 1000000000\n" + "200000000 1000000000", "3000000000");
	}
}
