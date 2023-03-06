package other.past201912_open;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("678", "1356");
	}

	@Test
	void case2() {
		check("abc", "error");
	}

	@Test
	void case3() {
		check("0x8", "error");
	}

	@Test
	void case4() {
		check("012", "24");
	}
}
