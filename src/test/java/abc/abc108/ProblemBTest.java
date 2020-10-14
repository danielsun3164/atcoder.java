package abc.abc108;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("0 0 0 1", "-1 1 -1 0");
	}

	@Test
	void case2() {
		check("2 3 6 6", "3 10 -1 7");
	}

	@Test
	void case3() {
		check("31 -41 -59 26", "-126 -64 -36 -131");
	}
}
