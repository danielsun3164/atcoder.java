package abc.abc151_200.abc186;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 3 2\n" + "2 2\n" + "3 3", "10");
	}

	@Test
	void case2() {
		check("5 4 4\n" + "3 2\n" + "3 4\n" + "4 2\n" + "5 2", "14");
	}

	@Test
	void case3() {
		check("200000 200000 0", "40000000000");
	}

	@Test
	void case4() {
		check("100000 200000 0", "20000000000");
	}
}
