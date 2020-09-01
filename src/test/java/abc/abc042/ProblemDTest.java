package abc.abc042;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 3 1 1", "2");
	}

	@Test
	void case2() {
		check("10 7 3 4", "3570");
	}

	@Test
	void case3() {
		check("100000 100000 99999 99999", "1");
	}

	@Test
	void case4() {
		check("100000 100000 44444 55555", "738162020");
	}
}
