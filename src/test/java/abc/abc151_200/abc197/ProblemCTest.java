package abc.abc151_200.abc197;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 5 7", "2");
	}

	@Test
	void case2() {
		check("3\n" + "10 10 10", "0");
	}

	@Test
	void case3() {
		check("4\n" + "1 3 3 1", "0");
	}
}
