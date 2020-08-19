package abc171;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2", "b");
	}

	@Test
	void case2() {
		check("27", "aa");
	}

	@Test
	void case3() {
		check("123456789", "jjddja");
	}

	@Test
	void case4() {
		check("1000000000000001", "gbdpxgrzxjm");
	}

	@Test
	void case5() {
		check("26", "z");
	}
}
