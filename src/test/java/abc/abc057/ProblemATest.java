package abc.abc057;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("9 12", "21");
	}

	@Test
	void case2() {
		check("19 0", "19");
	}

	@Test
	void case3() {
		check("23 2", "1");
	}
}
