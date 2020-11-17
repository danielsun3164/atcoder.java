package abc.abc131;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3776", "Bad");
	}

	@Test
	void case2() {
		check("8080", "Good");
	}

	@Test
	void case3() {
		check("1333", "Bad");
	}

	@Test
	void case4() {
		check("0024", "Bad");
	}
}
