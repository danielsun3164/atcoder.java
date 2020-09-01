package abc.abc061;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "1 1\n" + "2 2\n" + "3 3", "3");
	}

	@Test
	void case2() {
		check("10 500000\n" + "1 100000\n" + "1 100000\n" + "1 100000\n" + "1 100000\n" + "1 100000\n"
				+ "100000 100000\n" + "100000 100000\n" + "100000 100000\n" + "100000 100000\n" + "100000 100000", "1");
	}
}
