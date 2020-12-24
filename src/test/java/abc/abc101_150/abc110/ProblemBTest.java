package abc.abc101_150.abc110;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 2 10 20\n" + "8 15 13\n" + "16 22", "No War");
	}

	@Test
	void case2() {
		check("4 2 -48 -1\n" + "-20 -35 -91 -23\n" + "-22 66", "War");
	}

	@Test
	void case3() {
		check("5 3 6 8\n" + "-10 3 1 5 -100\n" + "100 6 14", "War");
	}
}
