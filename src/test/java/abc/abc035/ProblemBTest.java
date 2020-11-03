package abc.abc035;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("UL?\n" + "1", "3");
	}

	@Test
	void case2() {
		check("UD?\n" + "1", "1");
	}

	@Test
	void case3() {
		check("UUUU?DDR?LLLL\n" + "1", "7");
	}

	@Test
	void case4() {
		check("UULL?\n" + "2", "3");
	}
}
