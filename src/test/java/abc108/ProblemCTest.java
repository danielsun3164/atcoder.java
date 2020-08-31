package abc108;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 2", "9");
	}

	@Test
	void case2() {
		check("5 3", "1");
	}

	@Test
	void case3() {
		check("31415 9265", "27");
	}

	@Test
	void case4() {
		check("35897 932", "114191");
	}
}
