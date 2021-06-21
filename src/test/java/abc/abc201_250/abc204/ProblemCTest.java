package abc.abc201_250.abc204;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2\n" + "2 3\n" + "3 2", "7");
	}

	@Test
	void case2() {
		check("3 0", "3");
	}

	@Test
	void case3() {
		check("4 4\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 1", "16");
	}
}
