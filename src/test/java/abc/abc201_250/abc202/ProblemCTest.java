package abc.abc201_250.abc202;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 2\n" + "3 1 2\n" + "2 3 2", "4");
	}

	@Test
	void case2() {
		check("4\n" + "1 1 1 1\n" + "1 1 1 1\n" + "1 2 3 4", "16");
	}

	@Test
	void case3() {
		check("3\n" + "2 3 3\n" + "1 3 3\n" + "1 1 1", "0");
	}
}
