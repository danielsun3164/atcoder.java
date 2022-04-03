package abc.abc201_250.abc214;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("abc", "4");
	}

	@Test
	void case2() {
		check("aa", "1");
	}

	@Test
	void case3() {
		check("acba", "6");
	}

	@Test
	void case4() {
		check("chokudai", "54");
	}
}
