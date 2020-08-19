package abc040;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("26", "1");
	}

	@Test
	void case2() {
		check("41", "4");
	}

	@Test
	void case3() {
		check("100000", "37");
	}
}
