package abc.abc118;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "2 10 8 40", "2");
	}

	@Test
	void case2() {
		check("4\n" + "5 13 8 1000000000", "1");
	}

	@Test
	void case3() {
		check("3\n" + "1000000000 1000000000 1000000000", "1000000000");
	}
}
