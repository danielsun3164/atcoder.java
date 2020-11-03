package other.apg4b;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemEX25Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "0 1 2\n" + "3\n" + "1 2 3\n" + "intersection", "1 2");
	}

	@Test
	void case2() {
		check("3\n" + "0 1 2\n" + "3\n" + "1 2 3\n" + "union_set", "0 1 2 3");
	}

	@Test
	void case3() {
		check("3\n" + "0 1 2\n" + "3\n" + "1 2 3\n" + "symmetric_diff", "0 3");
	}

	@Test
	void case4() {
		check("3\n" + "0 1 2\n" + "3\n" + "1 2 3\n" + "subtract 2", "0 1");
	}

	@Test
	void case5() {
		check("3\n" + "0 1 49\n" + "3\n" + "1 2 3\n" + "increment", "0 1 2");
	}

	@Test
	void case6() {
		check("3\n" + "0 1 49\n" + "3\n" + "1 2 3\n" + "decrement", "0 48 49");
	}
}
