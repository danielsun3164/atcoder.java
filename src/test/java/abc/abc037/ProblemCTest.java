package abc.abc037;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "1 2 4 8 16", "49");
	}

	@Test
	void case2() {
		check("20 10\n"
				+ "100000000 100000000 98667799 100000000 100000000 100000000 100000000 99986657 100000000 100000000 100000000 100000000 100000000 98995577 100000000 100000000 99999876 100000000 100000000 99999999",
				"10988865195");
	}

	@Test
	void case3() {
		check("3 3\n" + "1 2 3", "6");
	}
}
