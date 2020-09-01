package abc.abc039;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1", "1");
	}

	@Test
	void case2() {
		check("981506241", "177");
	}

	@Test
	void case3() {
		check("390625", "25");
	}
}
