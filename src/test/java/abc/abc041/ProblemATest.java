package abc.abc041;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("atcoder\n" + "3", "c");
	}

	@Test
	void case2() {
		check("beginner\n" + "1", "b");
	}

	@Test
	void case3() {
		check("contest\n" + "7", "t");
	}

	@Test
	void case4() {
		check("z\n" + "1", "z");
	}
}
