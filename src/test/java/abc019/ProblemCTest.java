package abc019;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 3", "2");
	}

	@Test
	void case2() {
		check("4\n" + "2 4 8 16", "1");
	}

	@Test
	void case3() {
		check("4\n" + "2 3 5 7", "4");
	}
}
