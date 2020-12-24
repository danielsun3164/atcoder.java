package abc.abc001_050.abc032;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "3\n" + "8", "12");
	}

	@Test
	void case2() {
		check("2\n" + "2\n" + "2", "2");
	}

	@Test
	void case3() {
		check("12\n" + "8\n" + "25", "48");
	}
}
