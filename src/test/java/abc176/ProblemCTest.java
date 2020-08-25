package abc176;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "2 1 5 4 3", "4");
	}

	@Test
	void case2() {
		check("5\n" + "3 3 3 3 3", "0");
	}
}
