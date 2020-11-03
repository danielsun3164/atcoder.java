package abc.abc031;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "1 -3 3 9 1 6", "6");
	}

	@Test
	void case2() {
		check("3\n" + "5 5 5", "10");
	}

	@Test
	void case3() {
		check("8\n" + "-1 10 -1 2 -1 10 -1 0", "-1");
	}
}
